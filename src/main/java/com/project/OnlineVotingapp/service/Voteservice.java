package com.project.OnlineVotingapp.service;
import java.util.*;

import com.project.OnlineVotingapp.entity.Vote;
public interface Voteservice {
	 List<Vote> getAllVotes();

	    Optional<Vote> getVoteById(Long voteId);

	    void saveVote(Vote vote);

	    void deleteVote(Long voteId);
}
