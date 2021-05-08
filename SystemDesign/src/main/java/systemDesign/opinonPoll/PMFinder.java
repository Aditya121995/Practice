package systemDesign.opinonPoll;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@Component
public class PMFinder {
    private List<Party> parties;

    public Candidate getPM() {
        List<Candidate> pmCandidates = new ArrayList<>();
        Candidate primeMinister = null;
        Party partyWon;
        for (Party party : parties) {
            pmCandidates.add(party.getPMCandidate());
        }

        parties.sort(Comparator.comparing(Party::constituenciesWon));
        Collections.reverse(parties);
        Party firstParty = parties.get(0);
        Party secondParty = parties.get(1);
        if (firstParty.constituenciesWon() != secondParty.constituenciesWon()) {
            partyWon = firstParty;
            primeMinister = partyWon.getPMCandidate();
        } else if (firstParty.totalVotes() != secondParty.totalVotes()) {
            partyWon = (firstParty.totalVotes() > secondParty.totalVotes()) ? firstParty : secondParty;
            primeMinister = partyWon.getPMCandidate();
        } else {
            Candidate firstCandidate = firstParty.getPMCandidate();
            Candidate secondCandidate = secondParty.getPMCandidate();
            if (firstCandidate.getGender() == "Female") {
                primeMinister = firstCandidate;
            }  else if (secondCandidate.getGender() == "Female") {
                primeMinister = secondCandidate;
            }
        }

        if (primeMinister != null) {
            return primeMinister;
        } else {
            System.out.println("No prime minister selected");
            return null;
        }
    }
}
