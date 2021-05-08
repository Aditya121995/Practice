package systemDesign.opinonPoll;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VoteShareDisplay {
    private List<Constituency> constituencies;
    private List<Party> parties;

    public VoteShareDisplay(List<Constituency> constituencies, List<Party> parties) {
        this.constituencies = constituencies;
        this.parties = parties;
    }

    public void partyWiseVoteShare(Constituency constituency) {
        List<Candidate> candidates = constituency.getCandidates();
        for (Candidate candidate : candidates) {
            System.out.println("Party " + candidate.getParty().getName() + " : " + candidate.getVoteCount() + " votes");
        }
        System.out.println("----------------------------------");
    }

    public void partyWiseVoteShareInIndia() {
        for (Party party : parties) {
            System.out.println("Party " + party.getName() + " : " + party.totalVotes() + " votes");
        }
        System.out.println("----------------------------------");
    }

    public void candidateVoteShare(Candidate candidate) {
        System.out.println("Candidate " + candidate.getName() + " : " + candidate.getVoteCount() + " votes");
        System.out.println("----------------------------------");
    }
}
