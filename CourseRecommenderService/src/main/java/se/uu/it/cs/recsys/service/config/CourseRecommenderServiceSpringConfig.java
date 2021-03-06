package se.uu.it.cs.recsys.service.config;

/*
 * #%L
 * CourseRecommenderService
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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import se.uu.it.cs.recsys.constraint.config.ConstraintSolverSpringConfig;
import se.uu.it.cs.recsys.persistence.config.PersistenceSpringConfig;
import se.uu.it.cs.recsys.ruleminer.config.CourseRecommenderRuleMinerSpringConfig;
import se.uu.it.cs.recsys.semantic.config.ComputingDomainReasonerSpringConfig;

/**
 *
 * @author Yong Huang &lt;yong.e.huang@gmail.com>&gt;
 */

@Configuration
@ComponentScan(basePackages = {"se.uu.it.cs.recsys.service"})
@Import(value = {
    CourseRecommenderRuleMinerSpringConfig.class,
    PersistenceSpringConfig.class,
    ConstraintSolverSpringConfig.class,
    ComputingDomainReasonerSpringConfig.class})
public class CourseRecommenderServiceSpringConfig {

}
