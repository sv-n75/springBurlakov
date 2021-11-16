package task_Strengthening_skills.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import task_Strengthening_skills.converter.ClientConverter;
import task_Strengthening_skills.converter.OrderConverter;
import task_Strengthening_skills.dto.AddressDTO;
import task_Strengthening_skills.dto.ClientDtoAll;
import task_Strengthening_skills.dto.OrderDtoAllClient;
import task_Strengthening_skills.exception.ClientException;
import task_Strengthening_skills.model.Address;
import task_Strengthening_skills.model.Client;
import task_Strengthening_skills.model.Order;
import task_Strengthening_skills.repository.AddressRepository;
import task_Strengthening_skills.repository.ClientRepository;
import task_Strengthening_skills.repository.OrdersRepository;

@ContextConfiguration(classes = {ClientService.class})
@RunWith(SpringRunner.class)
public class ClientServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private ClientConverter clientConverter;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @MockBean
    private OrderConverter orderConverter;

    @MockBean
    private OrdersRepository ordersRepository;

    @Test
    public void testCreateClient() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        assertEquals(123L, this.clientService.createClient(client1).longValue());
        verify(this.clientRepository).save((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testCreateClient2() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(0);

        Client client1 = new Client();
        client1.setAddress(address2);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client1);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client2 = new Client();
        client2.setAddress(address1);
        client2.setId(123L);
        client2.setOrderList(orderList);
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");
        assertEquals(123L, this.clientService.createClient(client2).longValue());
        verify(this.clientRepository).save((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testCreateClient3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        assertEquals(123L, this.clientService.createClient(client1).longValue());
        verify(this.clientRepository).save((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testCreateClient4() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(0);

        Client client1 = new Client();
        client1.setAddress(address2);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client1);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client2 = new Client();
        client2.setAddress(address1);
        client2.setId(123L);
        client2.setOrderList(orderList);
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");
        assertEquals(123L, this.clientService.createClient(client2).longValue());
        verify(this.clientRepository).save((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testGetAll() {
        when(this.clientRepository.findAll()).thenReturn(new ArrayList<Client>());
        ArrayList<ClientDtoAll> clientDtoAllList = new ArrayList<ClientDtoAll>();
        when(this.clientConverter.converterClients((List<Client>) any())).thenReturn(clientDtoAllList);
        List<ClientDtoAll> actualAll = this.clientService.getAll();
        assertSame(clientDtoAllList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(this.clientRepository).findAll();
        verify(this.clientConverter).converterClients((List<Client>) any());
    }

    @Test
    public void testGetAll2() {
        when(this.clientRepository.findAll()).thenReturn(new ArrayList<Client>());
        ArrayList<ClientDtoAll> clientDtoAllList = new ArrayList<ClientDtoAll>();
        when(this.clientConverter.converterClients((List<Client>) any())).thenReturn(clientDtoAllList);
        List<ClientDtoAll> actualAll = this.clientService.getAll();
        assertSame(clientDtoAllList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(this.clientRepository).findAll();
        verify(this.clientConverter).converterClients((List<Client>) any());
    }

    @Test
    public void testGetClientDtoAllById() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        AddressDTO address1 = new AddressDTO(123L, 1, "District Name", "Name Of The Settlement", "Street Name", 10, 10, 10);

        ClientDtoAll clientDtoAll = new ClientDtoAll(123L, "Dr", "42", "4105551212", address1,
                new ArrayList<OrderDtoAllClient>());

        when(this.clientConverter.converterClient((Client) any())).thenReturn(clientDtoAll);
        assertSame(clientDtoAll, this.clientService.getClientDtoAllById(123L));
        verify(this.clientRepository).findById((Long) any());
        verify(this.clientConverter).converterClient((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testGetClientDtoAllById2() {
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        AddressDTO address = new AddressDTO(123L, 1, "District Name", "Name Of The Settlement", "Street Name", 10, 10, 10);

        when(this.clientConverter.converterClient((Client) any()))
                .thenReturn(new ClientDtoAll(123L, "Dr", "42", "4105551212", address, new ArrayList<OrderDtoAllClient>()));
        thrown.expect(ClientException.class);
        this.clientService.getClientDtoAllById(123L);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testGetClientDtoAllById3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        AddressDTO address1 = new AddressDTO(123L, 1, "District Name", "Name Of The Settlement", "Street Name", 10, 10, 10);

        ClientDtoAll clientDtoAll = new ClientDtoAll(123L, "Dr", "42", "4105551212", address1,
                new ArrayList<OrderDtoAllClient>());

        when(this.clientConverter.converterClient((Client) any())).thenReturn(clientDtoAll);
        assertSame(clientDtoAll, this.clientService.getClientDtoAllById(123L));
        verify(this.clientRepository).findById((Long) any());
        verify(this.clientConverter).converterClient((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testGetClientDtoAllById4() {
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        AddressDTO address = new AddressDTO(123L, 1, "District Name", "Name Of The Settlement", "Street Name", 10, 10, 10);

        when(this.clientConverter.converterClient((Client) any()))
                .thenReturn(new ClientDtoAll(123L, "Dr", "42", "4105551212", address, new ArrayList<OrderDtoAllClient>()));
        thrown.expect(ClientException.class);
        this.clientService.getClientDtoAllById(123L);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testAddOrder() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(1);

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setId(123L);
        client2.setOrderList(new ArrayList<Order>());
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client2);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        assertEquals("Order is added", this.clientService.addOrder(123L, order));
        verify(this.clientRepository).findById((Long) any());
        verify(this.clientRepository).save((Client) any());
        Client client3 = order.getClient();
        assertSame(client, client3);
        assertEquals(1, client3.getOrderList().size());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testAddOrder2() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client1);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        thrown.expect(ClientException.class);
        this.clientService.addOrder(123L, order);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testAddOrder3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(1);

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setId(123L);
        client2.setOrderList(new ArrayList<Order>());
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client2);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        assertEquals("Order is added", this.clientService.addOrder(123L, order));
        verify(this.clientRepository).findById((Long) any());
        verify(this.clientRepository).save((Client) any());
        Client client3 = order.getClient();
        assertSame(client, client3);
        assertEquals(1, client3.getOrderList().size());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testAddOrder4() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client1);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        thrown.expect(ClientException.class);
        this.clientService.addOrder(123L, order);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testGetOrderByIdClientAndNumberOrder() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        thrown.expect(ClientException.class);
        this.clientService.getOrderByIdClientAndNumberOrder(123L, 10);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testGetOrderByIdClientAndNumberOrder2() {
        OrderDtoAllClient orderDtoAllClient = new OrderDtoAllClient(123L, 10, new Date(1L),
                "The characteristics of someone or something", 1, 123);

        when(this.orderConverter.converterAllClient((Order) any())).thenReturn(orderDtoAllClient);

        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(0);

        Client client = new Client();
        client.setAddress(address1);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client1 = new Client();
        client1.setAddress(address);
        client1.setId(123L);
        client1.setOrderList(orderList);
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(orderDtoAllClient, this.clientService.getOrderByIdClientAndNumberOrder(123L, 10));
        verify(this.orderConverter).converterAllClient((Order) any());
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testGetOrderByIdClientAndNumberOrder3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        thrown.expect(ClientException.class);
        this.clientService.getOrderByIdClientAndNumberOrder(123L, 10);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testGetOrderByIdClientAndNumberOrder4() {
        OrderDtoAllClient orderDtoAllClient = new OrderDtoAllClient(123L, 10, new Date(1L),
                "The characteristics of someone or something", 1, 123);

        when(this.orderConverter.converterAllClient((Order) any())).thenReturn(orderDtoAllClient);

        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(0);

        Client client = new Client();
        client.setAddress(address1);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client1 = new Client();
        client1.setAddress(address);
        client1.setId(123L);
        client1.setOrderList(orderList);
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(orderDtoAllClient, this.clientService.getOrderByIdClientAndNumberOrder(123L, 10));
        verify(this.orderConverter).converterAllClient((Order) any());
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testChangeClientById() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(1);

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setId(123L);
        client2.setOrderList(new ArrayList<Order>());
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");
        assertEquals("Client is changed", this.clientService.changeClientById(123L, client2));
        verify(this.clientRepository).findById((Long) any());
        verify(this.clientRepository).save((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testChangeClientById2() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        thrown.expect(ClientException.class);
        this.clientService.changeClientById(123L, client1);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testChangeClientById3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(1);

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setId(123L);
        client2.setOrderList(new ArrayList<Order>());
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");
        assertEquals("Client is changed", this.clientService.changeClientById(123L, client2));
        verify(this.clientRepository).findById((Long) any());
        verify(this.clientRepository).save((Client) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testChangeClientById4() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        when(this.clientRepository.save((Client) any())).thenReturn(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        thrown.expect(ClientException.class);
        this.clientService.changeClientById(123L, client1);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testDeleteClientById() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        doNothing().when(this.clientRepository).delete((Client) any());
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Client is deleted", this.clientService.deleteClientById(123L));
        verify(this.clientRepository).delete((Client) any());
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testDeleteClientById2() {
        doNothing().when(this.clientRepository).delete((Client) any());
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        thrown.expect(ClientException.class);
        this.clientService.deleteClientById(123L);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testDeleteClientById3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        doNothing().when(this.clientRepository).delete((Client) any());
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Client is deleted", this.clientService.deleteClientById(123L));
        verify(this.clientRepository).delete((Client) any());
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testDeleteClientById4() {
        doNothing().when(this.clientRepository).delete((Client) any());
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        thrown.expect(ClientException.class);
        this.clientService.deleteClientById(123L);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testChangeOrder() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client1);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        thrown.expect(ClientException.class);
        this.clientService.changeOrder(123L, 10, order);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testChangeOrder2() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        when(this.ordersRepository.save((Order) any())).thenReturn(order);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(0);

        Client client1 = new Client();
        client1.setAddress(address2);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order1 = new Order();
        order1.setSum(0);
        order1.setClient(client1);
        order1.setNumber(10);
        order1.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        order1.setDateOfCreation(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        order1.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order1);

        Client client2 = new Client();
        client2.setAddress(address1);
        client2.setId(123L);
        client2.setOrderList(orderList);
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client2);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address3 = new Address();
        address3.setNameOfTheSettlement("Name Of The Settlement");
        address3.setHouseNumber(10);
        address3.setStreetName("Street Name");
        address3.setDistrictName("District Name");
        address3.setOfficeRoomNumber(10);
        address3.setCaseNumber(10);
        address3.setId(123L);
        address3.setRegionCode(1);

        Client client3 = new Client();
        client3.setAddress(address3);
        client3.setId(123L);
        client3.setOrderList(new ArrayList<Order>());
        client3.setPhoneNumber("4105551212");
        client3.setTitle("Dr");
        client3.setIndividualTaxNumber("42");

        Order order2 = new Order();
        order2.setSum(1);
        order2.setClient(client3);
        order2.setNumber(10);
        order2.setId(123L);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        order2.setDateOfCreation(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        order2.setDescription("The characteristics of someone or something");
        assertEquals("Order is changed", this.clientService.changeOrder(123L, 10, order2));
        verify(this.ordersRepository).save((Order) any());
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testChangeOrder3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Client client1 = new Client();
        client1.setAddress(address1);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client1);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        thrown.expect(ClientException.class);
        this.clientService.changeOrder(123L, 10, order);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testChangeOrder4() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(1);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");
        when(this.ordersRepository.save((Order) any())).thenReturn(order);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(1);

        Address address2 = new Address();
        address2.setNameOfTheSettlement("Name Of The Settlement");
        address2.setHouseNumber(10);
        address2.setStreetName("Street Name");
        address2.setDistrictName("District Name");
        address2.setOfficeRoomNumber(10);
        address2.setCaseNumber(10);
        address2.setId(123L);
        address2.setRegionCode(0);

        Client client1 = new Client();
        client1.setAddress(address2);
        client1.setId(123L);
        client1.setOrderList(new ArrayList<Order>());
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");

        Order order1 = new Order();
        order1.setSum(0);
        order1.setClient(client1);
        order1.setNumber(10);
        order1.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        order1.setDateOfCreation(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        order1.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order1);

        Client client2 = new Client();
        client2.setAddress(address1);
        client2.setId(123L);
        client2.setOrderList(orderList);
        client2.setPhoneNumber("4105551212");
        client2.setTitle("Dr");
        client2.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client2);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);

        Address address3 = new Address();
        address3.setNameOfTheSettlement("Name Of The Settlement");
        address3.setHouseNumber(10);
        address3.setStreetName("Street Name");
        address3.setDistrictName("District Name");
        address3.setOfficeRoomNumber(10);
        address3.setCaseNumber(10);
        address3.setId(123L);
        address3.setRegionCode(1);

        Client client3 = new Client();
        client3.setAddress(address3);
        client3.setId(123L);
        client3.setOrderList(new ArrayList<Order>());
        client3.setPhoneNumber("4105551212");
        client3.setTitle("Dr");
        client3.setIndividualTaxNumber("42");

        Order order2 = new Order();
        order2.setSum(1);
        order2.setClient(client3);
        order2.setNumber(10);
        order2.setId(123L);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        order2.setDateOfCreation(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        order2.setDescription("The characteristics of someone or something");
        assertEquals("Order is changed", this.clientService.changeOrder(123L, 10, order2));
        verify(this.ordersRepository).save((Order) any());
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testDeleteOrderByIdClientAndNumber() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        thrown.expect(ClientException.class);
        this.clientService.deleteOrderByIdClientAndNumber(123L, 10);
        verify(this.clientRepository, atLeast(1)).findById((Long) any());
    }

    @Test
    public void testDeleteOrderByIdClientAndNumber2() {
        doNothing().when(this.ordersRepository).delete((Order) any());

        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(0);

        Client client = new Client();
        client.setAddress(address1);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client1 = new Client();
        client1.setAddress(address);
        client1.setId(123L);
        client1.setOrderList(orderList);
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Order is deleted", this.clientService.deleteOrderByIdClientAndNumber(123L, 10));
        verify(this.ordersRepository).delete((Order) any());
        verify(this.clientRepository, atLeast(1)).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testDeleteOrderByIdClientAndNumber3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        thrown.expect(ClientException.class);
        this.clientService.deleteOrderByIdClientAndNumber(123L, 10);
        verify(this.clientRepository, atLeast(1)).findById((Long) any());
    }

    @Test
    public void testDeleteOrderByIdClientAndNumber4() {
        doNothing().when(this.ordersRepository).delete((Order) any());

        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(0);

        Client client = new Client();
        client.setAddress(address1);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client1 = new Client();
        client1.setAddress(address);
        client1.setId(123L);
        client1.setOrderList(orderList);
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Order is deleted", this.clientService.deleteOrderByIdClientAndNumber(123L, 10));
        verify(this.ordersRepository).delete((Order) any());
        verify(this.clientRepository, atLeast(1)).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testFindById() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(client, this.clientService.findById(123L));
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testFindById2() {
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        thrown.expect(ClientException.class);
        this.clientService.findById(123L);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testFindById3() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(client, this.clientService.findById(123L));
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testFindById4() {
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        thrown.expect(ClientException.class);
        this.clientService.findById(123L);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testFindOrderByIdClientAndNumber() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        thrown.expect(ClientException.class);
        this.clientService.findOrderByIdClientAndNumber(123L, 10);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testFindOrderByIdClientAndNumber2() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(0);

        Client client = new Client();
        client.setAddress(address1);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client1 = new Client();
        client1.setAddress(address);
        client1.setId(123L);
        client1.setOrderList(orderList);
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(order, this.clientService.findOrderByIdClientAndNumber(123L, 10));
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testFindOrderByIdClientAndNumber3() {
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        thrown.expect(ClientException.class);
        this.clientService.findOrderByIdClientAndNumber(123L, 10);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testFindOrderByIdClientAndNumber4() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Client client = new Client();
        client.setAddress(address);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        thrown.expect(ClientException.class);
        this.clientService.findOrderByIdClientAndNumber(123L, 10);
        verify(this.clientRepository).findById((Long) any());
    }

    @Test
    public void testFindOrderByIdClientAndNumber5() {
        Address address = new Address();
        address.setNameOfTheSettlement("Name Of The Settlement");
        address.setHouseNumber(10);
        address.setStreetName("Street Name");
        address.setDistrictName("District Name");
        address.setOfficeRoomNumber(10);
        address.setCaseNumber(10);
        address.setId(123L);
        address.setRegionCode(1);

        Address address1 = new Address();
        address1.setNameOfTheSettlement("Name Of The Settlement");
        address1.setHouseNumber(10);
        address1.setStreetName("Street Name");
        address1.setDistrictName("District Name");
        address1.setOfficeRoomNumber(10);
        address1.setCaseNumber(10);
        address1.setId(123L);
        address1.setRegionCode(0);

        Client client = new Client();
        client.setAddress(address1);
        client.setId(123L);
        client.setOrderList(new ArrayList<Order>());
        client.setPhoneNumber("4105551212");
        client.setTitle("Dr");
        client.setIndividualTaxNumber("42");

        Order order = new Order();
        order.setSum(0);
        order.setClient(client);
        order.setNumber(10);
        order.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setDateOfCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        order.setDescription("The characteristics of someone or something");

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Client client1 = new Client();
        client1.setAddress(address);
        client1.setId(123L);
        client1.setOrderList(orderList);
        client1.setPhoneNumber("4105551212");
        client1.setTitle("Dr");
        client1.setIndividualTaxNumber("42");
        Optional<Client> ofResult = Optional.<Client>of(client1);
        when(this.clientRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(order, this.clientService.findOrderByIdClientAndNumber(123L, 10));
        verify(this.clientRepository).findById((Long) any());
        assertTrue(this.clientService.getAll().isEmpty());
    }

    @Test
    public void testFindOrderByIdClientAndNumber6() {
        when(this.clientRepository.findById((Long) any())).thenReturn(Optional.<Client>empty());
        thrown.expect(ClientException.class);
        this.clientService.findOrderByIdClientAndNumber(123L, 10);
        verify(this.clientRepository).findById((Long) any());
    }
}

