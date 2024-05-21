package com.project.OnlineVotingapp.service;

import java.util.*;

import com.project.OnlineVotingapp.entity.Election;

public interface ElectionService {
	List<Election> getAllElections();

	Optional<Election> getElectionById(Long electionId);

	void saveElection(Election election);

	void deleteElection(Long electionId);
}
