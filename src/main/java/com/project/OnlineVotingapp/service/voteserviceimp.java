package com.project.OnlineVotingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingapp.entity.Vote;
import com.project.OnlineVotingapp.repository.Votedao;

@Service
public class voteserviceimp implements Voteservice {
	@Autowired
	private Votedao voteRepository;

	@Override
	public List<Vote> getAllVotes() {
		return voteRepository.findAll();
	}

	@Override
	public Optional<Vote> getVoteById(Long voteId) {
		return voteRepository.findById(voteId);
	}

	@Override
	public void saveVote(Vote vote) {
		voteRepository.save(vote);
	}

	@Override
	public void deleteVote(Long voteId) {
		voteRepository.deleteById(voteId);
	}

}
