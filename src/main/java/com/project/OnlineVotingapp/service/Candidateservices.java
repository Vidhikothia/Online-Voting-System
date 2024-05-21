package com.project.OnlineVotingapp.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingapp.entity.Candidate;

public interface Candidateservices {
	List<Candidate> getAllCandidates();

    Optional<Candidate> getCandidateById(Long candidateId);

    void saveCandidate(Candidate candidate);

    void deleteCandidate(Long candidateId);
}
