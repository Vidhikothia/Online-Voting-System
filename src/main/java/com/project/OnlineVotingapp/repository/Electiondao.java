package com.project.OnlineVotingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.OnlineVotingapp.entity.*;

@Repository
public interface Electiondao extends JpaRepository<Election, Long> {

}
