package com.project.OnlineVotingapp.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingapp.entity.User;
import com.project.OnlineVotingapp.entity.Vote;
import com.project.OnlineVotingapp.service.Userserviceimp;
import com.project.OnlineVotingapp.service.voteserviceimp;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
	@Autowired
	private voteserviceimp voteService;

	@GetMapping
	public List<Vote> getAllVotes() {
		return voteService.getAllVotes();
	}

	@GetMapping("/{id}")
	public Vote getVoteById(@PathVariable Long id) {
		return voteService.getVoteById(id)
				.orElseThrow(() -> new NoSuchElementException("Vote not found with id " + id));
	}

	@PostMapping
	public Vote createVote(@RequestBody Vote vote) {
		voteService.saveVote(vote);
		return vote;
	}

	@PutMapping("/{id}")
	public Vote updateVote(@PathVariable Long id, @RequestBody Vote updatedVote) {
		Vote vote = voteService.getVoteById(id)
				.orElseThrow(() -> new NoSuchElementException("Vote not found with id " + id));

		// Update vote fields
		vote.setUser(updatedVote.getUser());
		vote.setCandidate(updatedVote.getCandidate());
		vote.setElection(updatedVote.getElection());
		vote.setTimestamp(updatedVote.getTimestamp());

		voteService.saveVote(vote);
		return vote;
	}

	@DeleteMapping("/{id}")
	public void deleteVote(@PathVariable Long id) {
		voteService.deleteVote(id);
	}
}
