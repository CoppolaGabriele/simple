package simple.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Hibernate;

@Entity(name = "Teams2")
@Table(name = "TEAMS")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TeamGen")
	@SequenceGenerator(sequenceName = "TEAM_SEQ", allocationSize = 1, name = "TeamGen")
	@Column(name = "TEAM_ID")
	private int teamId;

	@Column(name = "NAME")
	private String name;

	@OneToOne(optional = false)
	@JoinColumn(name = "LEADER_ID")
	private Coder leader;

	@ManyToMany
	@JoinTable(name = "team_coder", joinColumns = @JoinColumn(name = "team_id"), 
			   						inverseJoinColumns = @JoinColumn(name = "coder_id"))
	private Set<Coder> coders;

	public Team() {

	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Team [id=" + teamId + ", name=" + name + ", leader=" + leader);
		if (Hibernate.isInitialized(coders)) {
			sb.append(", coders=");
			sb.append(coders);
		}
		return sb.toString();
	}

	public Coder getLeader() {
		return leader;
	}

	public void setLeader(Coder leader) {
		this.leader = leader;
	}

	public Set<Coder> getCoders() {
		return coders;
	}

	public void setCoders(Set<Coder> coders) {
		this.coders = coders;
	}

}
