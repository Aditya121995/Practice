package systemDesign.opinonPoll;

import lombok.Data;

@Data
public class Candidate {
    private String name;
    private String gender;
    private Integer voteCount;
    private Boolean isWinner;
    private Party party;

    public Candidate(String name, String gender, Integer voteCount, Party party) {
        this.gender = gender;
        this.name = name;
        this.voteCount = voteCount;
        this.party = party;
        this.isWinner = false;
        party.addCandidate(this);
    }

}
