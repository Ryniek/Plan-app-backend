package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.SubjectIdea;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class SubjectIdeaResponse {
    private Long id;
    private Boolean existing;
    private Boolean approved;
    private Boolean toRemove;
    private LocalDateTime sendingTime;
    private String subjectName;
    private String ideaExplanation;
    private String goals;
    private String resourcesNeeded;
    private Integer semester;
    private Integer ects;
    private ContactHoursResponse contactHours;
    private NonContactHoursResponse nonContactHours;
    //TODO zrobic wewnetrzna chyba klaske do tego
    private MajorModuleResponse majorModule;
    private TutorResponse tutor;
    private UserResponse user;
    private ModuleSubjectResponse majorModuleSubject;
    private Set<SubjectEffectResponse> subjectIdeaEffects = new HashSet<>();

    @Data
    private static class MajorModuleResponse {
        private Long id;
        private String majorName;
        private StudyType majorType;
        private String majorYear;
        private String moduleName;
        private Boolean specialized;

        private static MajorModuleResponse toResponse(MajorModule majorModule) {
            MajorModuleResponse result = new MajorModuleResponse();
            result.setId(majorModule.getId());
            result.setMajorName(majorModule.getMajor().getName());
            result.setMajorType(majorModule.getMajor().getStudyType());
            result.setMajorYear(majorModule.getMajor().getYears());
            result.setModuleName(majorModule.getModule().getName());
            result.setSpecialized(majorModule.getModule().getSpecialized());
            return result;
        }
    }

    public static SubjectIdeaResponse toResponse(SubjectIdea subjectIdea) {
        SubjectIdeaResponse result = new SubjectIdeaResponse();
        result.setId(subjectIdea.getId());
        result.setExisting(subjectIdea.getExisting());
        result.setApproved(subjectIdea.getApproved());
        result.setToRemove(subjectIdea.getToRemove());
        result.setSendingTime(subjectIdea.getSendingTime());
        result.setSubjectName(subjectIdea.getSubjectName());
        result.setIdeaExplanation(subjectIdea.getIdeaExplanation());
        result.setGoals(subjectIdea.getGoals());
        result.setResourcesNeeded(subjectIdea.getResourcesNeeded());
        result.setSemester(subjectIdea.getSemester());
        result.setEcts(subjectIdea.getEcts());
        if(subjectIdea.getContactHours() != null) result.setContactHours(ContactHoursResponse.toResponse(subjectIdea.getContactHours()));
        if(subjectIdea.getNonContactHours() != null) result.setNonContactHours(NonContactHoursResponse.toResponse(subjectIdea.getNonContactHours()));
        if(subjectIdea.getMajorModule() != null) result.setMajorModule(MajorModuleResponse.toResponse(subjectIdea.getMajorModule()));
        if(subjectIdea.getTutor() != null) result.setTutor(TutorResponse.toResponse(subjectIdea.getTutor()));
        result.setUser(UserResponse.toResponse(subjectIdea.getUser()));
        if(subjectIdea.getMajorModuleSubject() != null) result.setMajorModuleSubject(ModuleSubjectResponse.toResponse(subjectIdea.getMajorModuleSubject()));
        result.setSubjectIdeaEffects(subjectIdea
                .getSubjectIdeaEffects().stream()
                .map(SubjectEffectResponse::toResponse)
                .collect(Collectors.toSet()));
        return result;
    }
}