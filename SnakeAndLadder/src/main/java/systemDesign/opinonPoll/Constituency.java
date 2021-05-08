package systemDesign.opinonPoll;

import lombok.Data;

import java.util.List;

@Data
public class Constituency {
    private String name;
    private List<Candidate> candidates;
    private Candidate winner;

    public Constituency(String name, List<Candidate> candidates) {
        this.name = name;
        this.candidates = candidates;
        setWinner();
    }

    private void setWinner() {
        Candidate winnerCandidate = null;
        Integer maxVote = -1;
        Integer secondMaxVote = -1;
        for (Candidate candidate : candidates) {
            if (candidate.getVoteCount() > maxVote) {
                maxVote = candidate.getVoteCount();
                winnerCandidate = candidate;
            }
        }
        for (Candidate candidate : candidates) {
            if (candidate.getVoteCount() > secondMaxVote && candidate != winnerCandidate) {
                secondMaxVote = candidate.getVoteCount();
            }
        }

        if (maxVote == secondMaxVote) {
            return;
        }
        winner = winnerCandidate;
        winner.setIsWinner(true);
    }
}
