package systemDesign.opinonPoll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Party {
    private String name;
    private List<Candidate> candidates;
    private Candidate partyCandidateForPM;

    public Party(String name) {
        this.name = name;
        candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public Candidate getPMCandidate() {
        Integer maxPartyVotes = -1;
        for (Candidate candidate : candidates) {
            if (candidate.getIsWinner() && candidate.getVoteCount() > maxPartyVotes) {
                maxPartyVotes = candidate.getVoteCount();
                partyCandidateForPM = candidate;
            }
        }

        return partyCandidateForPM;
    }

    public Integer constituenciesWon() {
        int count = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getIsWinner()) {
                count += 1;
            }
        }

        return count;
    }

    public Integer totalVotes() {
        int totalVotes = 0;
        for (Candidate candidate : candidates) {
            totalVotes += candidate.getVoteCount();
        }

        return totalVotes;
    }
}
