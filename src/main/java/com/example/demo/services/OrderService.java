package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CreateOrderDTO;
import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.models.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PersonRepository;

@Service
public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final PersonRepository personRepository;

    public OrderService(ModelMapper modelMapper, OrderRepository orderRepository, PersonRepository personRepository) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getByID(int id) {
        return orderRepository.findById(id).get();
    }

    public OrderRequestDTO save(Order order) {
        Order saveOrder = orderRepository.save(order);
        return this.mapperToOrderRequestDTO(saveOrder);
    }

    public Order edit(int id, CreateOrderDTO createOrderDTO) {
        Order order = orderRepository.getReferenceById(id);
        order.setAddress(createOrderDTO.getAddress());
        order.setPrice(createOrderDTO.getPrice());
        order.setComment(createOrderDTO.getComment());
        order.setPhone(createOrderDTO.getPhone());
        order.setStatus(createOrderDTO.getStatus());
        order.setDeliveryman(personRepository.findById(createOrderDTO.getClient()).get());
        order.setClient(personRepository.findById(createOrderDTO.getClient()).get());
        order.setManager(personRepository.findById(createOrderDTO.getDeliveryman()).get());
        orderRepository.save(order);
        return order;
    } 

    public void save(CreateOrderDTO createOrderDTO) {
        Order mapOrder = this.mapperToOrder(createOrderDTO);
        mapOrder.setClient(personRepository.findById(createOrderDTO.getClient()).get());
        mapOrder.setDeliveryman(personRepository.findById(createOrderDTO.getDeliveryman()).get());
        mapOrder.setManager(personRepository.findById(createOrderDTO.getDeliveryman()).get());
        orderRepository.save(mapOrder);
    }


    public void deleteByID(int id) {
        orderRepository.deleteById(id);
    }

    // Mappers

    public Order mapperToOrder(CreateOrderDTO createOrderDTO) {
        return modelMapper.map(createOrderDTO, Order.class);
    }

    public Order mapperToOrder(OrderRequestDTO orderRequestDTO) {
        return modelMapper.map(orderRequestDTO, Order.class);
    }

    public OrderRequestDTO mapperToOrderRequestDTO(Optional<Order> optional) {
        return modelMapper.map(optional, OrderRequestDTO.class);
    }

    public OrderRequestDTO mapperToOrderRequestDTO(Order order) {
        return modelMapper.map(order, OrderRequestDTO.class);
    }
}
