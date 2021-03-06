/* Licensed under the Apache License, Version 2.0 (the "License");
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
 */

package org.flowable.form.api;

import org.flowable.engine.common.api.query.Query;

/**
 * Allows programmatic querying of {@link FormDeployment}s.
 * 
 * Note that it is impossible to retrieve the deployment resources through the results of this operation, since that would cause a huge transfer of (possibly) unneeded bytes over the wire.
 * 
 * To retrieve the actual bytes of a deployment resource use the operations on the {@link RepositoryService#getDeploymentResourceNames(String)} and
 * {@link RepositoryService#getResourceAsStream(String, String)}
 * 
 * @author Tijs Rademakers
 * @author Joram Barrez
 */
public interface FormDeploymentQuery extends Query<FormDeploymentQuery, FormDeployment> {

    /**
     * Only select deployments with the given deployment id.
     */
    FormDeploymentQuery deploymentId(String deploymentId);

    /**
     * Only select deployments with the given name.
     */
    FormDeploymentQuery deploymentName(String name);

    /**
     * Only select deployments with a name like the given string.
     */
    FormDeploymentQuery deploymentNameLike(String nameLike);

    /**
     * Only select deployments with the given category.
     * 
     * @see DeploymentBuilder#category(String)
     */
    FormDeploymentQuery deploymentCategory(String category);

    /**
     * Only select deployments that have a different category then the given one.
     * 
     * @see DeploymentBuilder#category(String)
     */
    FormDeploymentQuery deploymentCategoryNotEquals(String categoryNotEquals);

    /**
     * Only select deployment that have the given tenant id.
     */
    FormDeploymentQuery deploymentTenantId(String tenantId);

    /**
     * Only select deployments with a tenant id like the given one.
     */
    FormDeploymentQuery deploymentTenantIdLike(String tenantIdLike);

    /**
     * Only select deployments that do not have a tenant id.
     */
    FormDeploymentQuery deploymentWithoutTenantId();

    /** Only select deployments with the given form definition key. */
    FormDeploymentQuery formDefinitionKey(String key);

    /**
     * Only select deployments with a form definition key like the given string.
     */
    FormDeploymentQuery formDefinitionKeyLike(String keyLike);

    /**
     * Only select deployment that have the given deployment parent id.
     */
    FormDeploymentQuery parentDeploymentId(String deploymentParentId);

    /**
     * Only select deployments with a deployment parent id like the given one.
     */
    FormDeploymentQuery parentDeploymentIdLike(String deploymentParentIdLike);

    // sorting ////////////////////////////////////////////////////////

    /**
     * Order by deployment id (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    FormDeploymentQuery orderByDeploymentId();

    /**
     * Order by deployment name (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    FormDeploymentQuery orderByDeploymentName();

    /**
     * Order by deployment time (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    FormDeploymentQuery orderByDeploymentTime();

    /**
     * Order by tenant id (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    FormDeploymentQuery orderByTenantId();
}
