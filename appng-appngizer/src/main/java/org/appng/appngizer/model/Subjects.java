/*
 * Copyright 2011-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.appng.appngizer.model;

import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

public class Subjects extends org.appng.appngizer.model.xml.Subjects implements UriAware {

	public Subjects(List<Subject> subjects) {
		this.getSubject().addAll(subjects);
		setSelf("/subject");
	}

	@Override
	public void applyUriComponents(UriComponentsBuilder builder) {
		for (org.appng.appngizer.model.xml.Subject subject : subject) {
			((UriAware) subject).applyUriComponents(builder.cloneBuilder());
		}
		UriAware.super.applyUriComponents(builder);
	}
}