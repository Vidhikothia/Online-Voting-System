package com.project.OnlineVotingapp.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingapp.entity.Candidate;
import com.project.OnlineVotingapp.service.Candidayteserviceimp;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	@Autowired
	private Candidayteserviceimp candidateService;

	@GetMapping
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	@GetMapping("/{id}")
	public Candidate getCandidateById(@PathVariable Long id) {
		return candidateService.getCandidateById(id)
				.orElseThrow(() -> new NoSuchElementException("Candidate not found with id " + id));
	}

	@PostMapping
	public Candidate createCandidate(@RequestBody Candidate candidate) {
		candidateService.saveCandidate(candidate);
		return candidate;
	}

	@PutMapping("/{id}")
	public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate updatedCandidate) {
		Candidate candidate = candidateService.getCandidateById(id)
				.orElseThrow(() -> new NoSuchElementException("Candidate not found with id " + id));

		// Update candidate fields
		candidate.setName(updatedCandidate.getName());
		candidate.setDescription(updatedCandidate.getDescription());

		candidateService.saveCandidate(candidate);
		return candidate;
	}

	@DeleteMapping("/{id}")
	public void deleteCandidate(@PathVariable Long id) {
		candidateService.deleteCandidate(id);
	}
}
