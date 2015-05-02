package org.phenotips.studies.family;

import org.phenotips.studies.family.internal.StatusResponse;

import org.xwiki.component.annotation.Role;

import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiDocument;

/**
 * Used for checking if actions, such as adding a certain patient to a family are valid.
 *
 * @version $Id$
 * @since 1.2RC1
 */
@Role
public interface Validation
{
    /**
     * A wrapper around {@link #canAddToFamily(XWikiDocument, String)}.
     *
     * @param familyAnchor resolved to a family document using {@link FamilyUtils#getFamilyDoc(XWikiDocument)}
     * @param patientId {@see #canAddToFamily(XWikiDocument, String)}
     * @return {@see #canAddToFamily}
     */
    StatusResponse canAddToFamily(String familyAnchor, String patientId) throws XWikiException;

    /**
     * Runs several different checks to determine if a patient is eligible to be added as a member to a family document.
     *
     * @param familyDoc to which the patient will be potentially added to
     * @param patientId patient id who will potentially be added to the family
     * @return a non-null {@link StatusResponse}
     */
    StatusResponse canAddToFamily(XWikiDocument familyDoc, String patientId)
        throws XWikiException;

    /**
     * Checks if the current user has edit access to the family.
     *
     * @param familyDoc must not be null
     * @return a {@link StatusResponse} with a status of 200 (ok) or 401 (insufficient permissions)
     */
    StatusResponse checkFamilyAccessWithResponse(XWikiDocument familyDoc);

    /**
     * Checks if the current user has edit access to a patient.
     *
     * @param patientDoc must not be null
     * @return true if has access; false otherwise
     */
    boolean hasPatientEditAccess(XWikiDocument patientDoc);
}
