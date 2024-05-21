package com.project.OnlineVotingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.OnlineVotingapp.entity.Candidate;
import com.project.OnlineVotingapp.entity.Vote;
@Repository
public interface Votedao extends JpaRepository<Vote,Long> {

}
