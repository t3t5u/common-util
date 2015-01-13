package com.github.t3t5u.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExtraFieldUtilsTest {
	static final int PUBLIC_STATIC_FINAL_INT_VALUE = 0x11;
	static final int PUBLIC_STATIC_INT_OLD_VALUE = 0x100;
	static final int PUBLIC_STATIC_INT_NEW_VALUE = 0x111;
	static final int PUBLIC_FINAL_INT_VALUE = 0x1000;
	static final int PUBLIC_FINAL_INT_NEW_VALUE = 0x1111;
	static final int PUBLIC_INT_OLD_VALUE = 0x10000;
	static final int PUBLIC_INT_NEW_VALUE = 0x11111;
	static final int PROTECTED_STATIC_FINAL_INT_VALUE = 0x22;
	static final int PROTECTED_STATIC_INT_OLD_VALUE = 0x200;
	static final int PROTECTED_STATIC_INT_NEW_VALUE = 0x222;
	static final int PROTECTED_FINAL_INT_VALUE = 0x2000;
	static final int PROTECTED_FINAL_INT_NEW_VALUE = 0x2222;
	static final int PROTECTED_INT_OLD_VALUE = 0x20000;
	static final int PROTECTED_INT_NEW_VALUE = 0x22222;
	static final int DEFAULT_STATIC_FINAL_INT_VALUE = 0x33;
	static final int DEFAULT_STATIC_INT_OLD_VALUE = 0x300;
	static final int DEFAULT_STATIC_INT_NEW_VALUE = 0x333;
	static final int DEFAULT_FINAL_INT_VALUE = 0x3000;
	static final int DEFAULT_FINAL_INT_NEW_VALUE = 0x3333;
	static final int DEFAULT_INT_OLD_VALUE = 0x30000;
	static final int DEFAULT_INT_NEW_VALUE = 0x33333;
	static final int PRIVATE_STATIC_FINAL_INT_VALUE = 0x44;
	static final int PRIVATE_STATIC_INT_OLD_VALUE = 0x400;
	static final int PRIVATE_STATIC_INT_NEW_VALUE = 0x444;
	static final int PRIVATE_FINAL_INT_VALUE = 0x4000;
	static final int PRIVATE_FINAL_INT_NEW_VALUE = 0x4444;
	static final int PRIVATE_INT_OLD_VALUE = 0x40000;
	static final int PRIVATE_INT_NEW_VALUE = 0x44444;
	static final int PUBLIC_STATIC_FINAL_INT_SUB_VALUE = 0x55;
	static final int PUBLIC_STATIC_INT_OLD_SUB_VALUE = 0x500;
	static final int PUBLIC_STATIC_INT_NEW_SUB_VALUE = 0x555;
	static final int PUBLIC_FINAL_INT_SUB_VALUE = 0x5000;
	static final int PUBLIC_FINAL_INT_NEW_SUB_VALUE = 0x5555;
	static final int PUBLIC_INT_OLD_SUB_VALUE = 0x50000;
	static final int PUBLIC_INT_NEW_SUB_VALUE = 0x55555;
	static final int PROTECTED_STATIC_FINAL_INT_SUB_VALUE = 0x66;
	static final int PROTECTED_STATIC_INT_OLD_SUB_VALUE = 0x600;
	static final int PROTECTED_STATIC_INT_NEW_SUB_VALUE = 0x666;
	static final int PROTECTED_FINAL_INT_SUB_VALUE = 0x6000;
	static final int PROTECTED_FINAL_INT_NEW_SUB_VALUE = 0x6666;
	static final int PROTECTED_INT_OLD_SUB_VALUE = 0x60000;
	static final int PROTECTED_INT_NEW_SUB_VALUE = 0x66666;
	static final int DEFAULT_STATIC_FINAL_INT_SUB_VALUE = 0x77;
	static final int DEFAULT_STATIC_INT_OLD_SUB_VALUE = 0x700;
	static final int DEFAULT_STATIC_INT_NEW_SUB_VALUE = 0x777;
	static final int DEFAULT_FINAL_INT_SUB_VALUE = 0x7000;
	static final int DEFAULT_FINAL_INT_NEW_SUB_VALUE = 0x7777;
	static final int DEFAULT_INT_OLD_SUB_VALUE = 0x70000;
	static final int DEFAULT_INT_NEW_SUB_VALUE = 0x77777;
	static final int PRIVATE_STATIC_FINAL_INT_SUB_VALUE = 0x88;
	static final int PRIVATE_STATIC_INT_OLD_SUB_VALUE = 0x800;
	static final int PRIVATE_STATIC_INT_NEW_SUB_VALUE = 0x888;
	static final int PRIVATE_FINAL_INT_SUB_VALUE = 0x8000;
	static final int PRIVATE_FINAL_INT_NEW_SUB_VALUE = 0x8888;
	static final int PRIVATE_INT_OLD_SUB_VALUE = 0x80000;
	static final int PRIVATE_INT_NEW_SUB_VALUE = 0x88888;
	static final int PUBLIC_STATIC_FINAL_INT_HIDING_VALUE = 0x99;
	static final int PUBLIC_STATIC_INT_OLD_HIDING_VALUE = 0x900;
	static final int PUBLIC_STATIC_INT_NEW_HIDING_VALUE = 0x999;
	static final int PUBLIC_FINAL_INT_HIDING_VALUE = 0x9000;
	static final int PUBLIC_FINAL_INT_NEW_HIDING_VALUE = 0x9999;
	static final int PUBLIC_INT_OLD_HIDING_VALUE = 0x90000;
	static final int PUBLIC_INT_NEW_HIDING_VALUE = 0x99999;
	static final int PROTECTED_STATIC_FINAL_INT_HIDING_VALUE = 0xAA;
	static final int PROTECTED_STATIC_INT_OLD_HIDING_VALUE = 0xA00;
	static final int PROTECTED_STATIC_INT_NEW_HIDING_VALUE = 0xAAA;
	static final int PROTECTED_FINAL_INT_HIDING_VALUE = 0xA000;
	static final int PROTECTED_FINAL_INT_NEW_HIDING_VALUE = 0xAAAA;
	static final int PROTECTED_INT_OLD_HIDING_VALUE = 0xA0000;
	static final int PROTECTED_INT_NEW_HIDING_VALUE = 0xAAAAA;
	static final int DEFAULT_STATIC_FINAL_INT_HIDING_VALUE = 0xBB;
	static final int DEFAULT_STATIC_INT_OLD_HIDING_VALUE = 0xB00;
	static final int DEFAULT_STATIC_INT_NEW_HIDING_VALUE = 0xBBB;
	static final int DEFAULT_FINAL_INT_HIDING_VALUE = 0xB000;
	static final int DEFAULT_FINAL_INT_NEW_HIDING_VALUE = 0xBBBB;
	static final int DEFAULT_INT_OLD_HIDING_VALUE = 0xB0000;
	static final int DEFAULT_INT_NEW_HIDING_VALUE = 0xBBBBB;
	static final int PRIVATE_STATIC_FINAL_INT_HIDING_VALUE = 0xCC;
	static final int PRIVATE_STATIC_INT_OLD_HIDING_VALUE = 0xC00;
	static final int PRIVATE_STATIC_INT_NEW_HIDING_VALUE = 0xCCC;
	static final int PRIVATE_FINAL_INT_HIDING_VALUE = 0xC000;
	static final int PRIVATE_FINAL_INT_NEW_HIDING_VALUE = 0xCCCC;
	static final int PRIVATE_INT_OLD_HIDING_VALUE = 0xC0000;
	static final int PRIVATE_INT_NEW_HIDING_VALUE = 0xCCCCC;
	static final String PUBLIC_STATIC_FINAL_STRING_VALUE = "PUBLIC_STATIC_FINAL_STRING_VALUE";
	static final String PUBLIC_STATIC_STRING_OLD_VALUE = "PUBLIC_STATIC_STRING_OLD_VALUE";
	static final String PUBLIC_STATIC_STRING_NEW_VALUE = "PUBLIC_STATIC_STRING_NEW_VALUE";
	static final String PUBLIC_FINAL_STRING_VALUE = "PUBLIC_FINAL_STRING_VALUE";
	static final String PUBLIC_FINAL_STRING_NEW_VALUE = "PUBLIC_FINAL_STRING_NEW_VALUE";
	static final String PUBLIC_STRING_OLD_VALUE = "PUBLIC_STRING_OLD_VALUE";
	static final String PUBLIC_STRING_NEW_VALUE = "PUBLIC_STRING_NEW_VALUE";
	static final String PROTECTED_STATIC_FINAL_STRING_VALUE = "PROTECTED_STATIC_FINAL_STRING_VALUE";
	static final String PROTECTED_STATIC_STRING_OLD_VALUE = "PROTECTED_STATIC_STRING_OLD_VALUE";
	static final String PROTECTED_STATIC_STRING_NEW_VALUE = "PROTECTED_STATIC_STRING_NEW_VALUE";
	static final String PROTECTED_FINAL_STRING_VALUE = "PROTECTED_FINAL_STRING_VALUE";
	static final String PROTECTED_FINAL_STRING_NEW_VALUE = "PROTECTED_FINAL_STRING_NEW_VALUE";
	static final String PROTECTED_STRING_OLD_VALUE = "PROTECTED_STRING_OLD_VALUE";
	static final String PROTECTED_STRING_NEW_VALUE = "PROTECTED_STRING_NEW_VALUE";
	static final String DEFAULT_STATIC_FINAL_STRING_VALUE = "DEFAULT_STATIC_FINAL_STRING_VALUE";
	static final String DEFAULT_STATIC_STRING_OLD_VALUE = "DEFAULT_STATIC_STRING_OLD_VALUE";
	static final String DEFAULT_STATIC_STRING_NEW_VALUE = "DEFAULT_STATIC_STRING_NEW_VALUE";
	static final String DEFAULT_FINAL_STRING_VALUE = "DEFAULT_FINAL_STRING_VALUE";
	static final String DEFAULT_FINAL_STRING_NEW_VALUE = "DEFAULT_FINAL_STRING_NEW_VALUE";
	static final String DEFAULT_STRING_OLD_VALUE = "DEFAULT_STRING_OLD_VALUE";
	static final String DEFAULT_STRING_NEW_VALUE = "DEFAULT_STRING_NEW_VALUE";
	static final String PRIVATE_STATIC_FINAL_STRING_VALUE = "PRIVATE_STATIC_FINAL_STRING_VALUE";
	static final String PRIVATE_STATIC_STRING_OLD_VALUE = "PRIVATE_STATIC_STRING_OLD_VALUE";
	static final String PRIVATE_STATIC_STRING_NEW_VALUE = "PRIVATE_STATIC_STRING_NEW_VALUE";
	static final String PRIVATE_FINAL_STRING_VALUE = "PRIVATE_FINAL_STRING_VALUE";
	static final String PRIVATE_FINAL_STRING_NEW_VALUE = "PRIVATE_FINAL_STRING_NEW_VALUE";
	static final String PRIVATE_STRING_OLD_VALUE = "PRIVATE_STRING_OLD_VALUE";
	static final String PRIVATE_STRING_NEW_VALUE = "PRIVATE_STRING_NEW_VALUE";
	static final String PUBLIC_STATIC_FINAL_STRING_SUB_VALUE = "PUBLIC_STATIC_FINAL_STRING_SUB_VALUE";
	static final String PUBLIC_STATIC_STRING_OLD_SUB_VALUE = "PUBLIC_STATIC_STRING_OLD_SUB_VALUE";
	static final String PUBLIC_STATIC_STRING_NEW_SUB_VALUE = "PUBLIC_STATIC_STRING_NEW_SUB_VALUE";
	static final String PUBLIC_FINAL_STRING_SUB_VALUE = "PUBLIC_FINAL_STRING_SUB_VALUE";
	static final String PUBLIC_FINAL_STRING_NEW_SUB_VALUE = "PUBLIC_FINAL_STRING_NEW_SUB_VALUE";
	static final String PUBLIC_STRING_OLD_SUB_VALUE = "PUBLIC_STRING_OLD_SUB_VALUE";
	static final String PUBLIC_STRING_NEW_SUB_VALUE = "PUBLIC_STRING_NEW_SUB_VALUE";
	static final String PROTECTED_STATIC_FINAL_STRING_SUB_VALUE = "PROTECTED_STATIC_FINAL_STRING_SUB_VALUE";
	static final String PROTECTED_STATIC_STRING_OLD_SUB_VALUE = "PROTECTED_STATIC_STRING_OLD_SUB_VALUE";
	static final String PROTECTED_STATIC_STRING_NEW_SUB_VALUE = "PROTECTED_STATIC_STRING_NEW_SUB_VALUE";
	static final String PROTECTED_FINAL_STRING_SUB_VALUE = "PROTECTED_FINAL_STRING_SUB_VALUE";
	static final String PROTECTED_FINAL_STRING_NEW_SUB_VALUE = "PROTECTED_FINAL_STRING_NEW_SUB_VALUE";
	static final String PROTECTED_STRING_OLD_SUB_VALUE = "PROTECTED_STRING_OLD_SUB_VALUE";
	static final String PROTECTED_STRING_NEW_SUB_VALUE = "PROTECTED_STRING_NEW_SUB_VALUE";
	static final String DEFAULT_STATIC_FINAL_STRING_SUB_VALUE = "DEFAULT_STATIC_FINAL_STRING_SUB_VALUE";
	static final String DEFAULT_STATIC_STRING_OLD_SUB_VALUE = "DEFAULT_STATIC_STRING_OLD_SUB_VALUE";
	static final String DEFAULT_STATIC_STRING_NEW_SUB_VALUE = "DEFAULT_STATIC_STRING_NEW_SUB_VALUE";
	static final String DEFAULT_FINAL_STRING_SUB_VALUE = "DEFAULT_FINAL_STRING_SUB_VALUE";
	static final String DEFAULT_FINAL_STRING_NEW_SUB_VALUE = "DEFAULT_FINAL_STRING_NEW_SUB_VALUE";
	static final String DEFAULT_STRING_OLD_SUB_VALUE = "DEFAULT_STRING_OLD_SUB_VALUE";
	static final String DEFAULT_STRING_NEW_SUB_VALUE = "DEFAULT_STRING_NEW_SUB_VALUE";
	static final String PRIVATE_STATIC_FINAL_STRING_SUB_VALUE = "PRIVATE_STATIC_FINAL_STRING_SUB_VALUE";
	static final String PRIVATE_STATIC_STRING_OLD_SUB_VALUE = "PRIVATE_STATIC_STRING_OLD_SUB_VALUE";
	static final String PRIVATE_STATIC_STRING_NEW_SUB_VALUE = "PRIVATE_STATIC_STRING_NEW_SUB_VALUE";
	static final String PRIVATE_FINAL_STRING_SUB_VALUE = "PRIVATE_FINAL_STRING_SUB_VALUE";
	static final String PRIVATE_FINAL_STRING_NEW_SUB_VALUE = "PRIVATE_FINAL_STRING_NEW_SUB_VALUE";
	static final String PRIVATE_STRING_OLD_SUB_VALUE = "PRIVATE_STRING_OLD_SUB_VALUE";
	static final String PRIVATE_STRING_NEW_SUB_VALUE = "PRIVATE_STRING_NEW_SUB_VALUE";
	static final String PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE = "PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE";
	static final String PUBLIC_STATIC_STRING_OLD_HIDING_VALUE = "PUBLIC_STATIC_STRING_OLD_HIDING_VALUE";
	static final String PUBLIC_STATIC_STRING_NEW_HIDING_VALUE = "PUBLIC_STATIC_STRING_NEW_HIDING_VALUE";
	static final String PUBLIC_FINAL_STRING_HIDING_VALUE = "PUBLIC_FINAL_STRING_HIDING_VALUE";
	static final String PUBLIC_FINAL_STRING_NEW_HIDING_VALUE = "PUBLIC_FINAL_STRING_NEW_HIDING_VALUE";
	static final String PUBLIC_STRING_OLD_HIDING_VALUE = "PUBLIC_STRING_OLD_HIDING_VALUE";
	static final String PUBLIC_STRING_NEW_HIDING_VALUE = "PUBLIC_STRING_NEW_HIDING_VALUE";
	static final String PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE = "PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE";
	static final String PROTECTED_STATIC_STRING_OLD_HIDING_VALUE = "PROTECTED_STATIC_STRING_OLD_HIDING_VALUE";
	static final String PROTECTED_STATIC_STRING_NEW_HIDING_VALUE = "PROTECTED_STATIC_STRING_NEW_HIDING_VALUE";
	static final String PROTECTED_FINAL_STRING_HIDING_VALUE = "PROTECTED_FINAL_STRING_HIDING_VALUE";
	static final String PROTECTED_FINAL_STRING_NEW_HIDING_VALUE = "PROTECTED_FINAL_STRING_NEW_HIDING_VALUE";
	static final String PROTECTED_STRING_OLD_HIDING_VALUE = "PROTECTED_STRING_OLD_HIDING_VALUE";
	static final String PROTECTED_STRING_NEW_HIDING_VALUE = "PROTECTED_STRING_NEW_HIDING_VALUE";
	static final String DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE = "DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE";
	static final String DEFAULT_STATIC_STRING_OLD_HIDING_VALUE = "DEFAULT_STATIC_STRING_OLD_HIDING_VALUE";
	static final String DEFAULT_STATIC_STRING_NEW_HIDING_VALUE = "DEFAULT_STATIC_STRING_NEW_HIDING_VALUE";
	static final String DEFAULT_FINAL_STRING_HIDING_VALUE = "DEFAULT_FINAL_STRING_HIDING_VALUE";
	static final String DEFAULT_FINAL_STRING_NEW_HIDING_VALUE = "DEFAULT_FINAL_STRING_NEW_HIDING_VALUE";
	static final String DEFAULT_STRING_OLD_HIDING_VALUE = "DEFAULT_STRING_OLD_HIDING_VALUE";
	static final String DEFAULT_STRING_NEW_HIDING_VALUE = "DEFAULT_STRING_NEW_HIDING_VALUE";
	static final String PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE = "PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE";
	static final String PRIVATE_STATIC_STRING_OLD_HIDING_VALUE = "PRIVATE_STATIC_STRING_OLD_HIDING_VALUE";
	static final String PRIVATE_STATIC_STRING_NEW_HIDING_VALUE = "PRIVATE_STATIC_STRING_NEW_HIDING_VALUE";
	static final String PRIVATE_FINAL_STRING_HIDING_VALUE = "PRIVATE_FINAL_STRING_HIDING_VALUE";
	static final String PRIVATE_FINAL_STRING_NEW_HIDING_VALUE = "PRIVATE_FINAL_STRING_NEW_HIDING_VALUE";
	static final String PRIVATE_STRING_OLD_HIDING_VALUE = "PRIVATE_STRING_OLD_HIDING_VALUE";
	static final String PRIVATE_STRING_NEW_HIDING_VALUE = "PRIVATE_STRING_NEW_HIDING_VALUE";
	private static final String PUBLIC_STATIC_FINAL_INT_FIELD_NAME = "PUBLIC_STATIC_FINAL_INT_FIELD";
	private static final String PUBLIC_STATIC_INT_FIELD_NAME = "publicStaticIntField";
	private static final String PUBLIC_FINAL_INT_FIELD_NAME = "publicFinalIntField";
	private static final String PUBLIC_INT_FIELD_NAME = "publicIntField";
	private static final String PUBLIC_STATIC_FINAL_STRING_FIELD_NAME = "PUBLIC_STATIC_FINAL_STRING_FIELD";
	private static final String PUBLIC_STATIC_STRING_FIELD_NAME = "publicStaticStringField";
	private static final String PUBLIC_FINAL_STRING_FIELD_NAME = "publicFinalStringField";
	private static final String PUBLIC_STRING_FIELD_NAME = "publicStringField";
	private static final String PROTECTED_STATIC_FINAL_INT_FIELD_NAME = "PROTECTED_STATIC_FINAL_INT_FIELD";
	private static final String PROTECTED_STATIC_INT_FIELD_NAME = "protectedStaticIntField";
	private static final String PROTECTED_FINAL_INT_FIELD_NAME = "protectedFinalIntField";
	private static final String PROTECTED_INT_FIELD_NAME = "protectedIntField";
	private static final String PROTECTED_STATIC_FINAL_STRING_FIELD_NAME = "PROTECTED_STATIC_FINAL_STRING_FIELD";
	private static final String PROTECTED_STATIC_STRING_FIELD_NAME = "protectedStaticStringField";
	private static final String PROTECTED_FINAL_STRING_FIELD_NAME = "protectedFinalStringField";
	private static final String PROTECTED_STRING_FIELD_NAME = "protectedStringField";
	private static final String DEFAULT_STATIC_FINAL_INT_FIELD_NAME = "DEFAULT_STATIC_FINAL_INT_FIELD";
	private static final String DEFAULT_STATIC_INT_FIELD_NAME = "defaultStaticIntField";
	private static final String DEFAULT_FINAL_INT_FIELD_NAME = "defaultFinalIntField";
	private static final String DEFAULT_INT_FIELD_NAME = "defaultIntField";
	private static final String DEFAULT_STATIC_FINAL_STRING_FIELD_NAME = "DEFAULT_STATIC_FINAL_STRING_FIELD";
	private static final String DEFAULT_STATIC_STRING_FIELD_NAME = "defaultStaticStringField";
	private static final String DEFAULT_FINAL_STRING_FIELD_NAME = "defaultFinalStringField";
	private static final String DEFAULT_STRING_FIELD_NAME = "defaultStringField";
	private static final String PRIVATE_STATIC_FINAL_INT_FIELD_NAME = "PRIVATE_STATIC_FINAL_INT_FIELD";
	private static final String PRIVATE_STATIC_INT_FIELD_NAME = "privateStaticIntField";
	private static final String PRIVATE_FINAL_INT_FIELD_NAME = "privateFinalIntField";
	private static final String PRIVATE_INT_FIELD_NAME = "privateIntField";
	private static final String PRIVATE_STATIC_FINAL_STRING_FIELD_NAME = "PRIVATE_STATIC_FINAL_STRING_FIELD";
	private static final String PRIVATE_STATIC_STRING_FIELD_NAME = "privateStaticStringField";
	private static final String PRIVATE_FINAL_STRING_FIELD_NAME = "privateFinalStringField";
	private static final String PRIVATE_STRING_FIELD_NAME = "privateStringField";
	private static final String PUBLIC_STATIC_FINAL_INT_SUB_FIELD_NAME = "PUBLIC_STATIC_FINAL_INT_SUB_FIELD";
	private static final String PUBLIC_STATIC_INT_SUB_FIELD_NAME = "publicStaticIntSubField";
	private static final String PUBLIC_FINAL_INT_SUB_FIELD_NAME = "publicFinalIntSubField";
	private static final String PUBLIC_INT_SUB_FIELD_NAME = "publicIntSubField";
	private static final String PUBLIC_STATIC_FINAL_STRING_SUB_FIELD_NAME = "PUBLIC_STATIC_FINAL_STRING_SUB_FIELD";
	private static final String PUBLIC_STATIC_STRING_SUB_FIELD_NAME = "publicStaticStringSubField";
	private static final String PUBLIC_FINAL_STRING_SUB_FIELD_NAME = "publicFinalStringSubField";
	private static final String PUBLIC_STRING_SUB_FIELD_NAME = "publicStringSubField";
	private static final String PROTECTED_STATIC_FINAL_INT_SUB_FIELD_NAME = "PROTECTED_STATIC_FINAL_INT_SUB_FIELD";
	private static final String PROTECTED_STATIC_INT_SUB_FIELD_NAME = "protectedStaticIntSubField";
	private static final String PROTECTED_FINAL_INT_SUB_FIELD_NAME = "protectedFinalIntSubField";
	private static final String PROTECTED_INT_SUB_FIELD_NAME = "protectedIntSubField";
	private static final String PROTECTED_STATIC_FINAL_STRING_SUB_FIELD_NAME = "PROTECTED_STATIC_FINAL_STRING_SUB_FIELD";
	private static final String PROTECTED_STATIC_STRING_SUB_FIELD_NAME = "protectedStaticStringSubField";
	private static final String PROTECTED_FINAL_STRING_SUB_FIELD_NAME = "protectedFinalStringSubField";
	private static final String PROTECTED_STRING_SUB_FIELD_NAME = "protectedStringSubField";
	private static final String DEFAULT_STATIC_FINAL_INT_SUB_FIELD_NAME = "DEFAULT_STATIC_FINAL_INT_SUB_FIELD";
	private static final String DEFAULT_STATIC_INT_SUB_FIELD_NAME = "defaultStaticIntSubField";
	private static final String DEFAULT_FINAL_INT_SUB_FIELD_NAME = "defaultFinalIntSubField";
	private static final String DEFAULT_INT_SUB_FIELD_NAME = "defaultIntSubField";
	private static final String DEFAULT_STATIC_FINAL_STRING_SUB_FIELD_NAME = "DEFAULT_STATIC_FINAL_STRING_SUB_FIELD";
	private static final String DEFAULT_STATIC_STRING_SUB_FIELD_NAME = "defaultStaticStringSubField";
	private static final String DEFAULT_FINAL_STRING_SUB_FIELD_NAME = "defaultFinalStringSubField";
	private static final String DEFAULT_STRING_SUB_FIELD_NAME = "defaultStringSubField";
	private static final String PRIVATE_STATIC_FINAL_INT_SUB_FIELD_NAME = "PRIVATE_STATIC_FINAL_INT_SUB_FIELD";
	private static final String PRIVATE_STATIC_INT_SUB_FIELD_NAME = "privateStaticIntSubField";
	private static final String PRIVATE_FINAL_INT_SUB_FIELD_NAME = "privateFinalIntSubField";
	private static final String PRIVATE_INT_SUB_FIELD_NAME = "privateIntSubField";
	private static final String PRIVATE_STATIC_FINAL_STRING_SUB_FIELD_NAME = "PRIVATE_STATIC_FINAL_STRING_SUB_FIELD";
	private static final String PRIVATE_STATIC_STRING_SUB_FIELD_NAME = "privateStaticStringSubField";
	private static final String PRIVATE_FINAL_STRING_SUB_FIELD_NAME = "privateFinalStringSubField";
	private static final String PRIVATE_STRING_SUB_FIELD_NAME = "privateStringSubField";

	@Before
	public void before() {
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_HIDING_VALUE);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_HIDING_VALUE);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_HIDING_VALUE, true);
	}

	@Test
	public void testStaticFinalField() {
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedStaticFinalField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testStaticFinalSubField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testStaticFinalHidingField() {
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredStaticFinalField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredStaticFinalField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredStaticFinalSubField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredStaticFinalHidingField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessStaticFinalField() {
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testForceAccessInheritedStaticFinalField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testForceAccessStaticFinalSubField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testForceAccessStaticFinalHidingField() {
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testForceAccessDeclaredStaticFinalField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testForceAccessInheritedDeclaredStaticFinalField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_VALUE, PUBLIC_STATIC_FINAL_INT_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_VALUE, PUBLIC_STATIC_FINAL_STRING_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_VALUE, PROTECTED_STATIC_FINAL_INT_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_VALUE, PROTECTED_STATIC_FINAL_STRING_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_VALUE, DEFAULT_STATIC_FINAL_INT_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_VALUE, DEFAULT_STATIC_FINAL_STRING_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_VALUE, PRIVATE_STATIC_FINAL_INT_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_VALUE, PRIVATE_STATIC_FINAL_STRING_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredStaticFinalSubField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, PUBLIC_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, PUBLIC_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_INT_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, PROTECTED_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, PROTECTED_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_INT_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, DEFAULT_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, DEFAULT_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_INT_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, PRIVATE_STATIC_FINAL_INT_SUB_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, PRIVATE_STATIC_FINAL_STRING_SUB_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testForceAccessDeclaredStaticFinalHidingField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_INT_FIELD_NAME, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, PUBLIC_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_FINAL_STRING_FIELD_NAME, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_INT_FIELD_NAME, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, PROTECTED_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_FINAL_STRING_FIELD_NAME, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_INT_FIELD_NAME, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, DEFAULT_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_FINAL_STRING_FIELD_NAME, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_INT_FIELD_NAME, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, PRIVATE_STATIC_FINAL_INT_HIDING_VALUE, true, IllegalAccessException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_FINAL_STRING_FIELD_NAME, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE, true, IllegalAccessException.class);
	}

	@Test
	public void testStaticField() {
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchStaticField() {
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedStaticField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testStaticSubField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testStaticHidingField() {
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_HIDING_VALUE, PUBLIC_STATIC_INT_NEW_HIDING_VALUE);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_HIDING_VALUE, PUBLIC_STATIC_STRING_NEW_HIDING_VALUE);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_HIDING_VALUE, PROTECTED_STATIC_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_HIDING_VALUE, PROTECTED_STATIC_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_HIDING_VALUE, DEFAULT_STATIC_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_HIDING_VALUE, DEFAULT_STATIC_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_HIDING_VALUE, PRIVATE_STATIC_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_HIDING_VALUE, PRIVATE_STATIC_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredStaticField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchDeclaredStaticField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredStaticField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredStaticSubField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredStaticHidingField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_HIDING_VALUE, PUBLIC_STATIC_INT_NEW_HIDING_VALUE);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_HIDING_VALUE, PUBLIC_STATIC_STRING_NEW_HIDING_VALUE);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_HIDING_VALUE, PROTECTED_STATIC_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_HIDING_VALUE, PROTECTED_STATIC_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_HIDING_VALUE, DEFAULT_STATIC_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_HIDING_VALUE, DEFAULT_STATIC_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_HIDING_VALUE, PRIVATE_STATIC_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_HIDING_VALUE, PRIVATE_STATIC_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessStaticField() {
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchStaticField() {
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedStaticField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessStaticSubField() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessStaticHidingField() {
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_HIDING_VALUE, PUBLIC_STATIC_INT_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_HIDING_VALUE, PUBLIC_STATIC_STRING_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_HIDING_VALUE, PROTECTED_STATIC_INT_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_HIDING_VALUE, PROTECTED_STATIC_STRING_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_HIDING_VALUE, DEFAULT_STATIC_INT_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_HIDING_VALUE, DEFAULT_STATIC_STRING_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_HIDING_VALUE, PRIVATE_STATIC_INT_NEW_HIDING_VALUE, true);
		assertStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_HIDING_VALUE, PRIVATE_STATIC_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredStaticField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchDeclaredStaticField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedDeclaredStaticField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_VALUE, PUBLIC_STATIC_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_VALUE, PUBLIC_STATIC_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_VALUE, PROTECTED_STATIC_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_VALUE, PROTECTED_STATIC_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_VALUE, DEFAULT_STATIC_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_VALUE, DEFAULT_STATIC_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_VALUE, PRIVATE_STATIC_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_VALUE, PRIVATE_STATIC_STRING_NEW_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredStaticSubField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, PUBLIC_STATIC_INT_OLD_SUB_VALUE, PUBLIC_STATIC_INT_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_SUB_VALUE, PUBLIC_STATIC_STRING_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, PROTECTED_STATIC_INT_OLD_SUB_VALUE, PROTECTED_STATIC_INT_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_SUB_VALUE, PROTECTED_STATIC_STRING_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, DEFAULT_STATIC_INT_OLD_SUB_VALUE, DEFAULT_STATIC_INT_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_SUB_VALUE, DEFAULT_STATIC_STRING_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, PRIVATE_STATIC_INT_OLD_SUB_VALUE, PRIVATE_STATIC_INT_NEW_SUB_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_SUB_VALUE, PRIVATE_STATIC_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredStaticHidingField() {
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_INT_FIELD_NAME, PUBLIC_STATIC_INT_OLD_HIDING_VALUE, PUBLIC_STATIC_INT_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STATIC_STRING_FIELD_NAME, PUBLIC_STATIC_STRING_OLD_HIDING_VALUE, PUBLIC_STATIC_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_INT_FIELD_NAME, PROTECTED_STATIC_INT_OLD_HIDING_VALUE, PROTECTED_STATIC_INT_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STATIC_STRING_FIELD_NAME, PROTECTED_STATIC_STRING_OLD_HIDING_VALUE, PROTECTED_STATIC_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_INT_FIELD_NAME, DEFAULT_STATIC_INT_OLD_HIDING_VALUE, DEFAULT_STATIC_INT_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STATIC_STRING_FIELD_NAME, DEFAULT_STATIC_STRING_OLD_HIDING_VALUE, DEFAULT_STATIC_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_INT_FIELD_NAME, PRIVATE_STATIC_INT_OLD_HIDING_VALUE, PRIVATE_STATIC_INT_NEW_HIDING_VALUE, true);
		assertDeclaredStaticField(ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STATIC_STRING_FIELD_NAME, PRIVATE_STATIC_STRING_OLD_HIDING_VALUE, PRIVATE_STATIC_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testFinalField() {
		assertField(newSuperTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertField(newSuperTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertField(newSuperTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchFinalField() {
		assertField(newSuperTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedFinalField() {
		assertField(newTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertField(newTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertField(newTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testFinalSubField() {
		assertField(newTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE);
		assertField(newTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE);
		assertField(newTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testFinalHidingField() {
		assertField(newHidingFieldTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchDeclaredFinalField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredFinalField() {
		assertDeclaredField(newTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalSubField() {
		assertDeclaredField(newTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalHidingField() {
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessFinalField() {
		assertField(newSuperTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchFinalField() {
		assertField(newSuperTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedFinalField() {
		assertField(newTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessFinalSubField() {
		assertField(newTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessFinalHidingField() {
		assertField(newHidingFieldTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredFinalField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchDeclaredFinalField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedDeclaredFinalField() {
		assertDeclaredField(newTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredFinalSubField() {
		assertDeclaredField(newTarget(), PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredFinalHidingField() {
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testField() {
		assertField(newSuperTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertField(newSuperTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertField(newSuperTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchField() {
		assertField(newSuperTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedField() {
		assertField(newTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertField(newTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertField(newTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testSubField() {
		assertField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE);
		assertField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE);
		assertField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testHidingField() {
		assertField(newHidingFieldTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchDeclaredField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredField() {
		assertDeclaredField(newTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredSubField() {
		assertDeclaredField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredHidingField() {
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessField() {
		assertField(newSuperTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchField() {
		assertField(newSuperTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedField() {
		assertField(newTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertField(newTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertField(newTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertField(newTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertField(newTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertField(newTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertField(newTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertField(newTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessSubField() {
		assertField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessHidingField() {
		assertField(newHidingFieldTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchDeclaredField() {
		assertDeclaredField(newSuperTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedDeclaredField() {
		assertDeclaredField(newTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredSubField() {
		assertDeclaredField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredHidingField() {
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testFinalFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchFinalFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedFinalFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedFinalFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testFinalSubFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testFinalSubFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testFinalHiddenFieldBySuperClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testFinalHidingFieldByClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchDeclaredFinalFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredFinalFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredFinalFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalSubFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalSubFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalHiddenFieldBySuperClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFinalHidingFieldByClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessFinalFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchFinalFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedFinalFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessInheritedFinalFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessFinalSubFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessFinalSubFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessFinalHiddenFieldBySuperClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessFinalHidingFieldByClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredFinalFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchDeclaredFinalFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedDeclaredFinalFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessInheritedDeclaredFinalFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredFinalSubFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredFinalSubFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_INT_SUB_FIELD_NAME, PUBLIC_FINAL_INT_SUB_VALUE, PUBLIC_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_FINAL_STRING_SUB_FIELD_NAME, PUBLIC_FINAL_STRING_SUB_VALUE, PUBLIC_FINAL_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_INT_SUB_FIELD_NAME, PROTECTED_FINAL_INT_SUB_VALUE, PROTECTED_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_FINAL_STRING_SUB_FIELD_NAME, PROTECTED_FINAL_STRING_SUB_VALUE, PROTECTED_FINAL_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_INT_SUB_FIELD_NAME, DEFAULT_FINAL_INT_SUB_VALUE, DEFAULT_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_FINAL_STRING_SUB_FIELD_NAME, DEFAULT_FINAL_STRING_SUB_VALUE, DEFAULT_FINAL_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_INT_SUB_FIELD_NAME, PRIVATE_FINAL_INT_SUB_VALUE, PRIVATE_FINAL_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_FINAL_STRING_SUB_FIELD_NAME, PRIVATE_FINAL_STRING_SUB_VALUE, PRIVATE_FINAL_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredFinalHiddenFieldBySuperClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_VALUE, PUBLIC_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_VALUE, PUBLIC_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_VALUE, PROTECTED_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_VALUE, PROTECTED_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_VALUE, DEFAULT_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_VALUE, DEFAULT_FINAL_STRING_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_VALUE, PRIVATE_FINAL_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_VALUE, PRIVATE_FINAL_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredFinalHidingFieldByClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_INT_FIELD_NAME, PUBLIC_FINAL_INT_HIDING_VALUE, PUBLIC_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_FINAL_STRING_FIELD_NAME, PUBLIC_FINAL_STRING_HIDING_VALUE, PUBLIC_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_INT_FIELD_NAME, PROTECTED_FINAL_INT_HIDING_VALUE, PROTECTED_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_FINAL_STRING_FIELD_NAME, PROTECTED_FINAL_STRING_HIDING_VALUE, PROTECTED_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_INT_FIELD_NAME, DEFAULT_FINAL_INT_HIDING_VALUE, DEFAULT_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_FINAL_STRING_FIELD_NAME, DEFAULT_FINAL_STRING_HIDING_VALUE, DEFAULT_FINAL_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_INT_FIELD_NAME, PRIVATE_FINAL_INT_HIDING_VALUE, PRIVATE_FINAL_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_FINAL_STRING_FIELD_NAME, PRIVATE_FINAL_STRING_HIDING_VALUE, PRIVATE_FINAL_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testSubFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testSubFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testHiddenFieldBySuperClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testHidingFieldByClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testNoSuchDeclaredFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testInheritedDeclaredFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredSubFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredSubFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredHiddenFieldBySuperClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testDeclaredHidingFieldByClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, IllegalArgumentException.class);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchFieldByClass() {
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessInheritedFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessSubFieldBySuperClass() {
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessSubFieldByClass() {
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessHiddenFieldBySuperClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessHidingFieldByClass() {
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, true);
		assertField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessNoSuchDeclaredFieldByClass() {
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newSuperTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessInheritedDeclaredFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessInheritedDeclaredFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredSubFieldBySuperClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true, IllegalArgumentException.class);
	}

	@Test
	public void testForceAccessDeclaredSubFieldByClass() {
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE, PUBLIC_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE, PUBLIC_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, PROTECTED_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, PROTECTED_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, DEFAULT_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, DEFAULT_STRING_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, PRIVATE_INT_NEW_SUB_VALUE, true);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, PRIVATE_STRING_NEW_SUB_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredHiddenFieldBySuperClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE, PUBLIC_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE, PUBLIC_STRING_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, PROTECTED_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, PROTECTED_STRING_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, DEFAULT_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, DEFAULT_STRING_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, PRIVATE_INT_NEW_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, PRIVATE_STRING_NEW_VALUE, true);
	}

	@Test
	public void testForceAccessDeclaredHidingFieldByClass() {
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE, PUBLIC_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE, PUBLIC_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, PROTECTED_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, PROTECTED_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, DEFAULT_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, DEFAULT_STRING_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, PRIVATE_INT_NEW_HIDING_VALUE, true);
		assertDeclaredField(newHidingFieldTarget(), ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, PRIVATE_STRING_NEW_HIDING_VALUE, true);
	}

	@Test
	public void 不正な値を書き込む() {
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PUBLIC_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PROTECTED_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, DEFAULT_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredStaticField(ExtraFieldUtilsTestTarget.class, PRIVATE_STATIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PUBLIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PROTECTED_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), DEFAULT_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), PRIVATE_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, new Object(), IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
		assertDeclaredField(newTarget(), ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, new Object(), true, IllegalArgumentException.class);
	}

	@Test
	public void nullになる() {
		assertThat(ExtraFieldUtils.readStaticFieldOrNull(null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.readStaticFieldOrNull(null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.readDeclaredStaticFieldOrNull(null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.readDeclaredStaticFieldOrNull(null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.readFieldOrNull(null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.readFieldOrNull(null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.readDeclaredFieldOrNull(null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.readDeclaredFieldOrNull(null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.readFieldOrNull(null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.readFieldOrNull(null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.readDeclaredFieldOrNull(null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.readDeclaredFieldOrNull(null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.writeStaticFieldOrNull(null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.writeStaticFieldOrNull(null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.writeDeclaredStaticFieldOrNull(null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.writeDeclaredStaticFieldOrNull(null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.writeFieldOrNull(null, null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.writeFieldOrNull(null, null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.writeDeclaredFieldOrNull(null, null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.writeDeclaredFieldOrNull(null, null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.writeFieldOrNull(null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.writeFieldOrNull(null, null, null, false), is(nullValue()));
		assertThat(ExtraFieldUtils.writeDeclaredFieldOrNull(null, null, null), is(nullValue()));
		assertThat(ExtraFieldUtils.writeDeclaredFieldOrNull(null, null, null, false), is(nullValue()));
	}

	private static <T, V> void assertStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertStaticField(clazz, fieldName, oldValue, newValue);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertStaticField(clazz, fieldName, oldValue, newValue, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertDeclaredStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertDeclaredStaticField(clazz, fieldName, oldValue, newValue);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertDeclaredStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertDeclaredStaticField(clazz, fieldName, oldValue, newValue, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertField(target, clazz, fieldName, oldValue, newValue);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertField(target, clazz, fieldName, oldValue, newValue, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertDeclaredField(target, clazz, fieldName, oldValue, newValue);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertDeclaredField(target, clazz, fieldName, oldValue, newValue, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertField(final T target, final String fieldName, final V oldValue, final V newValue, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertField(target, fieldName, oldValue, newValue);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertField(final T target, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertField(target, fieldName, oldValue, newValue, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertDeclaredField(final T target, final String fieldName, final V oldValue, final V newValue, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertDeclaredField(target, fieldName, oldValue, newValue);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertDeclaredField(final T target, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			assertDeclaredField(target, fieldName, oldValue, newValue, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertStaticField(final Class<T> clazz, final String fieldName, final Object value, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeStaticField(clazz, fieldName, value);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertStaticField(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeStaticField(clazz, fieldName, value, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertDeclaredStaticField(final Class<T> clazz, final String fieldName, final Object value, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeDeclaredStaticField(clazz, fieldName, value);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertDeclaredStaticField(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeDeclaredStaticField(clazz, fieldName, value, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeField(target, clazz, fieldName, value);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeField(target, clazz, fieldName, value, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeDeclaredField(target, clazz, fieldName, value);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeDeclaredField(target, clazz, fieldName, value, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertField(final T target, final String fieldName, final Object value, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeField(target, fieldName, value);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertField(final T target, final String fieldName, final Object value, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeField(target, fieldName, value, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertDeclaredField(final T target, final String fieldName, final Object value, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeDeclaredField(target, fieldName, value);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T> void assertDeclaredField(final T target, final String fieldName, final Object value, final boolean forceAccess, final Class<? extends Throwable> expected) {
		Throwable t = null;
		try {
			writeDeclaredField(target, fieldName, value, forceAccess);
		} catch (final RuntimeException e) {
			t = e.getCause() != null ? e.getCause() : e;
		}
		assertThat(t, is(instanceOf(expected)));
	}

	private static <T, V> void assertStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue) {
		assertThat(ExtraFieldUtils.<V> readStaticField(clazz, fieldName), is(oldValue));
		assertThat(ExtraFieldUtils.writeStaticField(clazz, fieldName, newValue), is(equalTo(clazz)));
		assertThat(ExtraFieldUtils.<V> readStaticField(clazz, fieldName), is(newValue));
	}

	private static <T, V> void assertStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess) {
		assertThat(ExtraFieldUtils.<V> readStaticField(clazz, fieldName, forceAccess), is(oldValue));
		assertThat(ExtraFieldUtils.writeStaticField(clazz, fieldName, newValue, forceAccess), is(equalTo(clazz)));
		assertThat(ExtraFieldUtils.<V> readStaticField(clazz, fieldName, forceAccess), is(newValue));
	}

	private static <T, V> void assertDeclaredStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue) {
		assertThat(ExtraFieldUtils.<V> readDeclaredStaticField(clazz, fieldName), is(oldValue));
		assertThat(ExtraFieldUtils.writeDeclaredStaticField(clazz, fieldName, newValue), is(equalTo(clazz)));
		assertThat(ExtraFieldUtils.<V> readDeclaredStaticField(clazz, fieldName), is(newValue));
	}

	private static <T, V> void assertDeclaredStaticField(final Class<T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess) {
		assertThat(ExtraFieldUtils.<V> readDeclaredStaticField(clazz, fieldName, forceAccess), is(oldValue));
		assertThat(ExtraFieldUtils.writeDeclaredStaticField(clazz, fieldName, newValue, forceAccess), is(equalTo(clazz)));
		assertThat(ExtraFieldUtils.<V> readDeclaredStaticField(clazz, fieldName, forceAccess), is(newValue));
	}

	private static <T, V> void assertField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue) {
		assertThat(ExtraFieldUtils.<V, T> readField(target, clazz, fieldName), is(oldValue));
		assertThat(ExtraFieldUtils.writeField(target, clazz, fieldName, newValue), is(target));
		assertThat(ExtraFieldUtils.<V, T> readField(target, clazz, fieldName), is(newValue));
	}

	private static <T, V> void assertField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess) {
		assertThat(ExtraFieldUtils.<V, T> readField(target, clazz, fieldName, forceAccess), is(oldValue));
		assertThat(ExtraFieldUtils.writeField(target, clazz, fieldName, newValue, forceAccess), is(target));
		assertThat(ExtraFieldUtils.<V, T> readField(target, clazz, fieldName, forceAccess), is(newValue));
	}

	private static <T, V> void assertDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue) {
		assertThat(ExtraFieldUtils.<V, T> readDeclaredField(target, clazz, fieldName), is(oldValue));
		assertThat(ExtraFieldUtils.writeDeclaredField(target, clazz, fieldName, newValue), is(target));
		assertThat(ExtraFieldUtils.<V, T> readDeclaredField(target, clazz, fieldName), is(newValue));
	}

	private static <T, V> void assertDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess) {
		assertThat(ExtraFieldUtils.<V, T> readDeclaredField(target, clazz, fieldName, forceAccess), is(oldValue));
		assertThat(ExtraFieldUtils.writeDeclaredField(target, clazz, fieldName, newValue, forceAccess), is(target));
		assertThat(ExtraFieldUtils.<V, T> readDeclaredField(target, clazz, fieldName, forceAccess), is(newValue));
	}

	private static <T, V> void assertField(final T target, final String fieldName, final V oldValue, final V newValue) {
		assertThat(ExtraFieldUtils.<V> readField(target, fieldName), is(oldValue));
		assertThat(ExtraFieldUtils.writeField(target, fieldName, newValue), is(target));
		assertThat(ExtraFieldUtils.<V> readField(target, fieldName), is(newValue));
	}

	private static <T, V> void assertField(final T target, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess) {
		assertThat(ExtraFieldUtils.<V> readField(target, fieldName, forceAccess), is(oldValue));
		assertThat(ExtraFieldUtils.writeField(target, fieldName, newValue, forceAccess), is(target));
		assertThat(ExtraFieldUtils.<V> readField(target, fieldName, forceAccess), is(newValue));
	}

	private static <T, V> void assertDeclaredField(final T target, final String fieldName, final V oldValue, final V newValue) {
		assertThat(ExtraFieldUtils.<V> readDeclaredField(target, fieldName), is(oldValue));
		assertThat(ExtraFieldUtils.writeDeclaredField(target, fieldName, newValue), is(target));
		assertThat(ExtraFieldUtils.<V> readDeclaredField(target, fieldName), is(newValue));
	}

	private static <T, V> void assertDeclaredField(final T target, final String fieldName, final V oldValue, final V newValue, final boolean forceAccess) {
		assertThat(ExtraFieldUtils.<V> readDeclaredField(target, fieldName, forceAccess), is(oldValue));
		assertThat(ExtraFieldUtils.writeDeclaredField(target, fieldName, newValue, forceAccess), is(target));
		assertThat(ExtraFieldUtils.<V> readDeclaredField(target, fieldName, forceAccess), is(newValue));
	}

	private static <T> void writeStaticField(final Class<T> clazz, final String fieldName, final Object value) {
		ExtraFieldUtils.writeStaticField(clazz, fieldName, value);
	}

	private static <T> void writeStaticField(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		ExtraFieldUtils.writeStaticField(clazz, fieldName, value, forceAccess);
	}

	private static <T> void writeDeclaredStaticField(final Class<T> clazz, final String fieldName, final Object value) {
		ExtraFieldUtils.writeDeclaredStaticField(clazz, fieldName, value);
	}

	private static <T> void writeDeclaredStaticField(final Class<T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		ExtraFieldUtils.writeDeclaredStaticField(clazz, fieldName, value, forceAccess);
	}

	private static <T> void writeField(final T target, final Class<? super T> clazz, final String fieldName, final Object value) {
		ExtraFieldUtils.writeField(target, clazz, fieldName, value);
	}

	private static <T> void writeField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		ExtraFieldUtils.writeField(target, clazz, fieldName, value, forceAccess);
	}

	private static <T> void writeDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final Object value) {
		ExtraFieldUtils.writeDeclaredField(target, clazz, fieldName, value);
	}

	private static <T> void writeDeclaredField(final T target, final Class<? super T> clazz, final String fieldName, final Object value, final boolean forceAccess) {
		ExtraFieldUtils.writeDeclaredField(target, clazz, fieldName, value, forceAccess);
	}

	private static <T> void writeField(final T target, final String fieldName, final Object value) {
		ExtraFieldUtils.writeField(target, fieldName, value);
	}

	private static <T> void writeField(final T target, final String fieldName, final Object value, final boolean forceAccess) {
		ExtraFieldUtils.writeField(target, fieldName, value, forceAccess);
	}

	private static <T> void writeDeclaredField(final T target, final String fieldName, final Object value) {
		ExtraFieldUtils.writeDeclaredField(target, fieldName, value);
	}

	private static <T> void writeDeclaredField(final T target, final String fieldName, final Object value, final boolean forceAccess) {
		ExtraFieldUtils.writeDeclaredField(target, fieldName, value, forceAccess);
	}

	private static ExtraFieldUtilsTestSuperTarget newSuperTarget() {
		final ExtraFieldUtilsTestSuperTarget target = new ExtraFieldUtilsTestSuperTarget();
		writeFields(target);
		return target;
	}

	private static ExtraFieldUtilsTestTarget newTarget() {
		final ExtraFieldUtilsTestTarget target = new ExtraFieldUtilsTestTarget();
		writeFields(target);
		writeSubFields(target);
		return target;
	}

	private static ExtraFieldUtilsTestHidingFieldTarget newHidingFieldTarget() {
		final ExtraFieldUtilsTestHidingFieldTarget target = new ExtraFieldUtilsTestHidingFieldTarget();
		writeFields(target);
		writeHidingFields(target);
		return target;
	}

	private static ExtraFieldUtilsTestSuperTarget writeFields(final ExtraFieldUtilsTestSuperTarget target) {
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_VALUE);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_VALUE);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestSuperTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_VALUE, true);
		return target;
	}

	private static ExtraFieldUtilsTestTarget writeSubFields(final ExtraFieldUtilsTestTarget target) {
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, PUBLIC_INT_SUB_FIELD_NAME, PUBLIC_INT_OLD_SUB_VALUE);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, PROTECTED_INT_SUB_FIELD_NAME, PROTECTED_INT_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, DEFAULT_INT_SUB_FIELD_NAME, DEFAULT_INT_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, PRIVATE_INT_SUB_FIELD_NAME, PRIVATE_INT_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, PUBLIC_STRING_SUB_FIELD_NAME, PUBLIC_STRING_OLD_SUB_VALUE);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, PROTECTED_STRING_SUB_FIELD_NAME, PROTECTED_STRING_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, DEFAULT_STRING_SUB_FIELD_NAME, DEFAULT_STRING_OLD_SUB_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestTarget.class, PRIVATE_STRING_SUB_FIELD_NAME, PRIVATE_STRING_OLD_SUB_VALUE, true);
		return target;
	}

	private static ExtraFieldUtilsTestHidingFieldTarget writeHidingFields(final ExtraFieldUtilsTestHidingFieldTarget target) {
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_INT_FIELD_NAME, PUBLIC_INT_OLD_HIDING_VALUE);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_INT_FIELD_NAME, PROTECTED_INT_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_INT_FIELD_NAME, DEFAULT_INT_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_INT_FIELD_NAME, PRIVATE_INT_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, PUBLIC_STRING_FIELD_NAME, PUBLIC_STRING_OLD_HIDING_VALUE);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, PROTECTED_STRING_FIELD_NAME, PROTECTED_STRING_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, DEFAULT_STRING_FIELD_NAME, DEFAULT_STRING_OLD_HIDING_VALUE, true);
		ExtraFieldUtils.writeField(target, ExtraFieldUtilsTestHidingFieldTarget.class, PRIVATE_STRING_FIELD_NAME, PRIVATE_STRING_OLD_HIDING_VALUE, true);
		return target;
	}
}
