package com.capg.graddle.invite;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import Sample_Gradle_Project.WelcomeNote;

class WelcomeNoteTest {

	@Test
	void testDisplay() {
	assertEquals("monisha",WelcomeNote.display());
	}
}
