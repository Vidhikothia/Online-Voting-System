package com.project.OnlineVotingapp.rest;

import com.project.OnlineVotingapp.service.ElectionService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.OnlineVotingapp.entity.Election;

@RestController
@RequestMapping("/api/elections")
public class ElectionController {
	@Autowired
	private ElectionService electionService;

	@GetMapping
	public List<Election> getAllElections() {
		return electionService.getAllElections();
	}

	@GetMapping("/{id}")
	public Election getElectionById(@PathVariable Long id) {
		return electionService.getElectionById(id)
				.orElseThrow(() -> new NoSuchElementException("Election not found with id " + id));
	}

	@PostMapping
	public Election createElection(@RequestBody Election election) {
		electionService.saveElection(election);
		return election;
	}

	@PutMapping("/{id}")
	public Election updateElection(@PathVariable Long id, @RequestBody Election updatedElection) {
		Election election = electionService.getElectionById(id)
				.orElseThrow(() -> new NoSuchElementException("Election not found with id " + id));

		// Update election fields
		election.setTitle(updatedElection.getTitle());
		election.setDescription(updatedElection.getDescription());
		election.setStartDate(updatedElection.getStartDate());
		election.setEndDate(updatedElection.getEndDate());

		electionService.saveElection(election);
		return election;
	}

	@DeleteMapping("/{id}")
	public void deleteElection(@PathVariable Long id) {
		electionService.deleteElection(id);
	}
}
