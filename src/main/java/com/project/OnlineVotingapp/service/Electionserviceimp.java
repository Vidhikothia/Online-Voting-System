package com.project.OnlineVotingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingapp.entity.Candidate;
import com.project.OnlineVotingapp.entity.Election;
import com.project.OnlineVotingapp.entity.User;
import com.project.OnlineVotingapp.repository.Electiondao;

@Service
public class Electionserviceimp implements ElectionService {
	@Autowired
	private Electiondao electionRepository;

	@Override
	public List<Election> getAllElections() {
		return electionRepository.findAll();
	}

	@Override
	public Optional<Election> getElectionById(Long electionId) {
		return electionRepository.findById(electionId);
	}

	@Override
	public void saveElection(Election election) {
		electionRepository.save(election);
	}

	@Override
	public void deleteElection(Long electionId) {
		electionRepository.deleteById(electionId);
	}

}
