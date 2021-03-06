package se.uu.it.cs.recsys.persistence.entity;

/*
 * #%L
 * CourseRecommenderPersistence
 * %%
 * Copyright (C) 2015 Yong Huang  <yong.e.huang@gmail.com >
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yong Huang &lt;yong.e.huang@gmail.com&gt;
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findAllDistinctAutoGenId", query = "SELECT DISTINCT(c.autoGenId) FROM Course c"),
    @NamedQuery(name = "Course.findByAutoGenId", query = "SELECT c FROM Course c WHERE c.autoGenId = :autoGenId"),
    @NamedQuery(name = "Course.findByAutoGenIds", query = "SELECT c FROM Course c WHERE c.autoGenId in :autoGenIds"),
    @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c "
            + "LEFT JOIN FETCH c.courseDomainRelevanceCollection WHERE c.code = :code"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByLevel", query = "SELECT c FROM Course c WHERE c.level = :level"),
    @NamedQuery(name = "Course.findByCredit", query = "SELECT c FROM Course c WHERE c.credit = :credit"),
    @NamedQuery(name = "Course.findByTaughtYear", query = "SELECT c FROM Course c WHERE c.taughtYear = :taughtYear"),
    @NamedQuery(name = "Course.findByStartPeriod", query = "SELECT c FROM Course c WHERE c.startPeriod = :startPeriod"),
    @NamedQuery(name = "Course.findByEndPeriod", query = "SELECT c FROM Course c WHERE c.endPeriod = :endPeriod"),
    @NamedQuery(name = "Course.findByTaughtYearAndStartPeriod", query = "SELECT c FROM Course c "
            + "WHERE c.taughtYear = :taughtYear and c.startPeriod = :startPeriod"),
    @NamedQuery(name = "Course.findByCodeAndTaughtYearAndStartPeriod", query = "SELECT c FROM Course c "
            + "WHERE c.code = :code and c.taughtYear = :taughtYear and c.startPeriod = :startPeriod")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "auto_gen_id")
    private Integer autoGenId;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "taught_year")
    private Short taughtYear;
    @Column(name = "start_period")
    private Short startPeriod;
    @Column(name = "end_period")
    private Short endPeriod;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<CourseDomainRelevance> courseDomainRelevanceCollection;
    @JoinColumn(name = "credit", referencedColumnName = "credit")
    @ManyToOne
    private SupportedCourseCredit credit;
    @JoinColumn(name = "level", referencedColumnName = "level")
    @ManyToOne
    private SupportedCourseLevel level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<CourseSelectionNormalized> courseSelectionNormalizedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<CourseSelectionOriginal> courseSelectionOriginalCollection;

    public Course() {
    }

    public Course(Integer autoGenId) {
        this.autoGenId = autoGenId;
    }

    public Integer getAutoGenId() {
        return autoGenId;
    }

    public void setAutoGenId(Integer autoGenId) {
        this.autoGenId = autoGenId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getTaughtYear() {
        return taughtYear;
    }

    public void setTaughtYear(Short taughtYear) {
        this.taughtYear = taughtYear;
    }

    public Short getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Short startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Short getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Short endPeriod) {
        this.endPeriod = endPeriod;
    }

    @XmlTransient
    public Collection<CourseDomainRelevance> getCourseDomainRelevanceCollection() {
        return courseDomainRelevanceCollection;
    }

    public void setCourseDomainRelevanceCollection(Collection<CourseDomainRelevance> courseDomainRelevanceCollection) {
        this.courseDomainRelevanceCollection = courseDomainRelevanceCollection;
    }

    public SupportedCourseCredit getCredit() {
        return credit;
    }

    public void setCredit(SupportedCourseCredit credit) {
        this.credit = credit;
    }

    public SupportedCourseLevel getLevel() {
        return level;
    }

    public void setLevel(SupportedCourseLevel level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<CourseSelectionNormalized> getCourseSelectionNormalizedCollection() {
        return courseSelectionNormalizedCollection;
    }

    public void setCourseSelectionNormalizedCollection(Collection<CourseSelectionNormalized> courseSelectionNormalizedCollection) {
        this.courseSelectionNormalizedCollection = courseSelectionNormalizedCollection;
    }

    @XmlTransient
    public Collection<CourseSelectionOriginal> getCourseSelectionOriginalCollection() {
        return courseSelectionOriginalCollection;
    }

    public void setCourseSelectionOriginalCollection(Collection<CourseSelectionOriginal> courseSelectionOriginalCollection) {
        this.courseSelectionOriginalCollection = courseSelectionOriginalCollection;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((autoGenId == null) ? 0 : autoGenId.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime
                * result
                + ((courseDomainRelevanceCollection == null) ? 0
                        : courseDomainRelevanceCollection.hashCode());
        result = prime
                * result
                + ((courseSelectionNormalizedCollection == null) ? 0
                        : courseSelectionNormalizedCollection.hashCode());
        result = prime
                * result
                + ((courseSelectionOriginalCollection == null) ? 0
                        : courseSelectionOriginalCollection.hashCode());
        result = prime * result + ((credit == null) ? 0 : credit.hashCode());
        result = prime * result
                + ((endPeriod == null) ? 0 : endPeriod.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((startPeriod == null) ? 0 : startPeriod.hashCode());
        result = prime * result
                + ((taughtYear == null) ? 0 : taughtYear.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Course other = (Course) obj;
        if (autoGenId == null) {
            if (other.autoGenId != null) {
                return false;
            }
        } else if (!autoGenId.equals(other.autoGenId)) {
            return false;
        }
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        if (courseDomainRelevanceCollection == null) {
            if (other.courseDomainRelevanceCollection != null) {
                return false;
            }
        } else if (!courseDomainRelevanceCollection
                .equals(other.courseDomainRelevanceCollection)) {
            return false;
        }
        if (courseSelectionNormalizedCollection == null) {
            if (other.courseSelectionNormalizedCollection != null) {
                return false;
            }
        } else if (!courseSelectionNormalizedCollection
                .equals(other.courseSelectionNormalizedCollection)) {
            return false;
        }
        if (courseSelectionOriginalCollection == null) {
            if (other.courseSelectionOriginalCollection != null) {
                return false;
            }
        } else if (!courseSelectionOriginalCollection
                .equals(other.courseSelectionOriginalCollection)) {
            return false;
        }
        if (credit == null) {
            if (other.credit != null) {
                return false;
            }
        } else if (!credit.equals(other.credit)) {
            return false;
        }
        if (endPeriod == null) {
            if (other.endPeriod != null) {
                return false;
            }
        } else if (!endPeriod.equals(other.endPeriod)) {
            return false;
        }
        if (level == null) {
            if (other.level != null) {
                return false;
            }
        } else if (!level.equals(other.level)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (startPeriod == null) {
            if (other.startPeriod != null) {
                return false;
            }
        } else if (!startPeriod.equals(other.startPeriod)) {
            return false;
        }
        if (taughtYear == null) {
            if (other.taughtYear != null) {
                return false;
            }
        } else if (!taughtYear.equals(other.taughtYear)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.uu.it.cs.recsys.persistence.entity.Course[ autoGenId=" + autoGenId + " ]";
    }

}
