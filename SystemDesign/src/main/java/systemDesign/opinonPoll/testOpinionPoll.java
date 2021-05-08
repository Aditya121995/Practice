package systemDesign.opinonPoll;

import java.util.Arrays;

public class testOpinionPoll {
    public static void main(String[] args) {
        Party party1 = new Party("AAA");
        Party party2 = new Party("BBB");
        Party party3 = new Party("CCC");
        Party party4 = new Party("DDD");
        Party party5 = new Party("EEE");
        Candidate candidate1 = new Candidate("a", "Female", 100, party1);
        Candidate candidate2 = new Candidate("aa", "Female", 70, party1);
        Candidate candidate3 = new Candidate("aaa", "Male", 20, party1);

        Candidate candidate4 = new Candidate("b", "Female", 20, party2);
        Candidate candidate5 = new Candidate("bb", "Male", 90, party2);
        Candidate candidate6 = new Candidate("bbb", "Male", 80, party2);

        Candidate candidate7 = new Candidate("c", "Male", 10, party3);
        Candidate candidate8 = new Candidate("cc", "Female", 10, party3);
        Candidate candidate9 = new Candidate("ccc", "Male", 40, party3);

        Candidate candidate10 = new Candidate("d", "Male", 50, party4);
        Candidate candidate11 = new Candidate("dd", "Female", 10, party4);
        Candidate candidate12 = new Candidate("ddd", "Male", 50, party4);

        Candidate candidate13 = new Candidate("e", "Male", 10, party5);
        Candidate candidate14 = new Candidate("ee", "Female", 20, party5);
        Candidate candidate15 = new Candidate("eee", "Male", 10, party5);

        Constituency constituency1 = new Constituency("constituency1", Arrays.asList(candidate1, candidate5, candidate8, candidate10, candidate13));
        Constituency constituency2 = new Constituency("constituency2", Arrays.asList(candidate3, candidate4, candidate7, candidate11, candidate15));
        Constituency constituency3 = new Constituency("constituency3", Arrays.asList(candidate2, candidate6, candidate9, candidate12, candidate14));

        VoteShareDisplay voteShareDisplay = new VoteShareDisplay(Arrays.asList(constituency1,constituency2,constituency3), Arrays.asList(party1,party2,party3,party4,party5));
        voteShareDisplay.partyWiseVoteShare(constituency1);
        voteShareDisplay.partyWiseVoteShareInIndia();
        voteShareDisplay.candidateVoteShare(candidate1);

        PMFinder pmFinder = new PMFinder();
        pmFinder.setParties(Arrays.asList(party1,party2,party3,party4,party5));

        System.out.println(pmFinder.getPM().getName());


    }
}
