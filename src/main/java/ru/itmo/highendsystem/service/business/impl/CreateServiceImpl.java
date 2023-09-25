package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.highendsystem.model.dto.full.*;
import ru.itmo.highendsystem.model.dto.partial.*;
import ru.itmo.highendsystem.service.business.CreateService;
import ru.itmo.highendsystem.service.data.*;

/**
 * Реализация {@link CreateService}
 */
@Service
public class CreateServiceImpl implements CreateService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightStatusService flightStatusService;
    @Autowired
    private  PlaneService planeService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private TicketService ticketService;

    @Override
    public boolean createEmployee(ShortEmployeeDto employee) {
        FullAccountDto account = accountService.getAccountById(employee.accountId());
        FullPositionDto position = positionService.getPositionById(employee.positionId());

        FullEmployeeDto fullEmployeeDto = new FullEmployeeDto();
        fullEmployeeDto.setEmploymentDate(employee.employeeDate());
        fullEmployeeDto.setAccount(account);
        fullEmployeeDto.setPosition(position);
        fullEmployeeDto.setSalary(employee.salary());
        return employeeService.saveEmployee(fullEmployeeDto);
    }

    @Override
    @Transactional
    public Long createAccount(ShortAccountDto account) {
        FullRoleDto role = roleService.getRoleById(account.getRoleId());
        FullHumanDto fullHumanDto = createHuman(account.getHuman());

        FullAccountDto fullAccountDto = new FullAccountDto();
        fullAccountDto.setNickname(account.getNickname());
        fullAccountDto.setPassword(passwordEncoder.encode(account.getPassword()));
        fullAccountDto.setHuman(fullHumanDto);
        fullAccountDto.setBonusMoney(account.getBonusMoney());
        fullAccountDto.setRegistrationDate(account.getRegistrationDate());
        fullAccountDto.setViolationCount(0);
        fullAccountDto.setRole(role);

        return accountService.saveAccount(fullAccountDto).getId();
    }

    @Override
    public Long createFlight(ShortFlightDto flight) {
        FullFlightDto flightDto = new FullFlightDto();
        FullFlightStatusDto flightStatus = flightStatusService.getFlightStatusById(flight.flightStatus());
        FullPlaneDto plane = planeService.getPlaneById(flight.plane());
        FullRouteDto route = routeService.getRouteById(flight.route());
        flightDto.setDateStart(flight.dateStart());
        flightDto.setDateFinish(flight.dateFinish());
        flightDto.setFlightStatus(flightStatus);
        flightDto.setPlane(plane);
        flightDto.setRoute(route);

        Long id = flightService.saveFlight(flightDto).getId();

        char[] places = new char[] {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < plane.getPassengerCount(); i++) {
            String placeName = Integer.toString(i) + places[i % places.length];
            ShortTicketDto ticketDto = new ShortTicketDto(id, 0, placeName);
            createTicket(ticketDto);
        }

        return id;
    }

    private Long createTicket(ShortTicketDto ticket) {
        FullTicketDto ticketDto = new FullTicketDto();
        ticketDto.setFlight(flightService.getFlightById(ticket.flight()));
        ticketDto.setCost(ticket.cost());
        ticketDto.setPlace(ticket.place());

        return ticketService.saveTicket(ticketDto).getId();
    }

    /**
     * Создание человека в системе
     * @param humanDtoWithoutId краткое дто человека
     * @return полное дто человека
     */
    private FullHumanDto createHuman(HumanDtoWithoutId humanDtoWithoutId) {
        FullDocumentDto fullDocumentDto = createDocument(humanDtoWithoutId.getDocument());
        FullHumanDto fullHumanDto = new FullHumanDto();
        fullHumanDto.setName(humanDtoWithoutId.getName());
        fullHumanDto.setSurname(humanDtoWithoutId.getSurname());
        fullHumanDto.setLastName(humanDtoWithoutId.getLastName());
        fullHumanDto.setBirthDate(humanDtoWithoutId.getBirthDate());
        fullHumanDto.setDocument(fullDocumentDto);
        return fullHumanDto;
    }

    /**
     * Создание дто документа
     * @param document краткое дто документа
     * @return полное дто документа
     */
    private FullDocumentDto createDocument(DocumentDtoWithoutId document) {
        FullDocumentTypeDto documentType = documentTypeService.getDocumentTypeById(document.getDocumentTypeId());
        FullDocumentDto fullDocumentDto = new FullDocumentDto();
        fullDocumentDto.setSeries(document.getSeries());
        fullDocumentDto.setNumber(document.getNumber());
        fullDocumentDto.setDocumentType(documentType);
        return fullDocumentDto;
    }
}
