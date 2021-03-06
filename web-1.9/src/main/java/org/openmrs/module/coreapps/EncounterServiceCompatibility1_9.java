/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.coreapps;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.Form;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.Visit;
import org.openmrs.VisitType;
import org.openmrs.annotation.OpenmrsProfile;
import org.openmrs.api.EncounterService;
import org.springframework.stereotype.Component;

@Component("coreapps.EncounterServiceCompatibility")
@OpenmrsProfile(openmrsPlatformVersion = "1.9.9 - 1.12.*")
public class EncounterServiceCompatibility1_9 implements EncounterServiceCompatibility {

	@Override
	public List<Encounter> getEncounters(EncounterService encounterService,
			Patient who, Location loc, Date fromDate, Date toDate,
			Collection<Form> enteredViaForms,
			Collection<EncounterType> encounterTypes,
			Collection<Provider> providers, Collection<VisitType> visitTypes,
			Collection<Visit> visits, boolean includeVoided) {

		return encounterService.getEncounters(who, loc, fromDate, toDate,
				enteredViaForms, encounterTypes, providers, visitTypes, visits,
				includeVoided);
	}
}