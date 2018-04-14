package com.tbo.sn.constants;

/**
 * @author tai
 * @since 3/31/18.
 */
public enum EducationAchievementType
{
    HIGHSCHOOL_DIPLOMA("Highschool Diploma"),
    ASSOCIATE_DEGREE("Associate Degree"),
    BACHELOR_DEGREE("Bachlor Degree"),
    MASTER_DEGREE("Master Degree"),
    DOCTORATE_DEGREE("Doctorate Degree");

    private String type;

    EducationAchievementType( String type )
    {
        this.type = type;
    }

}
