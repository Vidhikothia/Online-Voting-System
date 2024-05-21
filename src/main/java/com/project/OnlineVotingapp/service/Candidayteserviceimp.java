package com.project.OnlineVotingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingapp.entity.Candidate;
import com.project.OnlineVotingapp.entity.User;
import com.project.OnlineVotingapp.repository.Candidatedao;

@Service
public class Candidayteserviceimp implements Candidateservices {
	@Autowired
	private Candidatedao candidateRepository;

	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();
	}

	public Optional<Candidate> getCandidateById(Long candidateId) {
		return candidateRepository.findById(candidateId);
	}

	public void saveCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	public void deleteCandidate(Long candidateId) {
		candidateRepository.deleteById(candidateId);
	}
}
