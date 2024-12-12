package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

}
