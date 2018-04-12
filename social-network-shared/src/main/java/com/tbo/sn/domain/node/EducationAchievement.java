package com.tbo.sn.domain.node;

import com.tbo.sn.constants.EducationAchievementField;
import com.tbo.sn.constants.EducationAchievementType;
import com.tbo.sn.constants.RelationshipType;

import java.util.Date;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author tai
 * @since 3/31/18.
 */
@NodeEntity
public class EducationAchievement
{
    private EducationAchievementType type;
    @Relationship(type = RelationshipType.FROM_SCHOOL, direction = Relationship.OUTGOING)
    private School fromSchool;
    private Date dateObtained;
    private EducationAchievementField field;

    public EducationAchievementType getType()
    {
        return type;
    }

    public EducationAchievement setType( EducationAchievementType type )
    {
        this.type = type;
        return this;
    }

    public School getFromSchool()
    {
        return fromSchool;
    }

    public EducationAchievement setFromSchool( School fromSchool )
    {
        this.fromSchool = fromSchool;
        return this;
    }

    public Date getDateObtained()
    {
        return dateObtained;
    }

    public EducationAchievement setDateObtained( Date dateObtained )
    {
        this.dateObtained = dateObtained;
        return this;
    }

    public EducationAchievementField getField()
    {
        return field;
    }

    public EducationAchievement setField( EducationAchievementField field )
    {
        this.field = field;
        return this;
    }
}
