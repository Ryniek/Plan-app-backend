package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SubjectEffectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long subjectId;
    private Long effectId;

    public SubjectEffectId() {
    }

    public SubjectEffectId(Long subjectId, Long effectId) {
        super();
        this.subjectId = subjectId;
        this.effectId = effectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((subjectId == null) ? 0 : subjectId.hashCode());
        result = prime * result
                + ((effectId == null) ? 0 : effectId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubjectEffectId other = (SubjectEffectId) obj;
        return Objects.equals(getSubjectId(), other.getSubjectId()) && Objects.equals(getEffectId(), other.getEffectId());
    }
}