package com.project.OnlineVotingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.OnlineVotingapp.entity.Candidate;

@Repository
public interface Candidatedao extends  JpaRepository<Candidate,Long>{

}
