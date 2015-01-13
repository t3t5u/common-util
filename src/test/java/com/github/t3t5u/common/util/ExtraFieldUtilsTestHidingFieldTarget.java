package com.github.t3t5u.common.util;

@SuppressWarnings("unused")
class ExtraFieldUtilsTestHidingFieldTarget extends ExtraFieldUtilsTestSuperTarget {
	public static final int PUBLIC_STATIC_FINAL_INT_FIELD = ExtraFieldUtilsTest.PUBLIC_STATIC_FINAL_INT_HIDING_VALUE;
	public static int publicStaticIntField;
	public final int publicFinalIntField = ExtraFieldUtilsTest.PUBLIC_FINAL_INT_HIDING_VALUE;
	public int publicIntField;
	public static final String PUBLIC_STATIC_FINAL_STRING_FIELD = ExtraFieldUtilsTest.PUBLIC_STATIC_FINAL_STRING_HIDING_VALUE;
	public static String publicStaticStringField;
	public final String publicFinalStringField = ExtraFieldUtilsTest.PUBLIC_FINAL_STRING_HIDING_VALUE;
	public String publicStringField;
	protected static final int PROTECTED_STATIC_FINAL_INT_FIELD = ExtraFieldUtilsTest.PROTECTED_STATIC_FINAL_INT_HIDING_VALUE;
	protected static int protectedStaticIntField;
	protected final int protectedFinalIntField = ExtraFieldUtilsTest.PROTECTED_FINAL_INT_HIDING_VALUE;
	protected int protectedIntField;
	protected static final String PROTECTED_STATIC_FINAL_STRING_FIELD = ExtraFieldUtilsTest.PROTECTED_STATIC_FINAL_STRING_HIDING_VALUE;
	protected static String protectedStaticStringField;
	protected final String protectedFinalStringField = ExtraFieldUtilsTest.PROTECTED_FINAL_STRING_HIDING_VALUE;
	protected String protectedStringField;
	static final int DEFAULT_STATIC_FINAL_INT_FIELD = ExtraFieldUtilsTest.DEFAULT_STATIC_FINAL_INT_HIDING_VALUE;
	static int defaultStaticIntField;
	final int defaultFinalIntField = ExtraFieldUtilsTest.DEFAULT_FINAL_INT_HIDING_VALUE;
	int defaultIntField;
	static final String DEFAULT_STATIC_FINAL_STRING_FIELD = ExtraFieldUtilsTest.DEFAULT_STATIC_FINAL_STRING_HIDING_VALUE;
	static String defaultStaticStringField;
	final String defaultFinalStringField = ExtraFieldUtilsTest.DEFAULT_FINAL_STRING_HIDING_VALUE;
	String defaultStringField;
	private static final int PRIVATE_STATIC_FINAL_INT_FIELD = ExtraFieldUtilsTest.PRIVATE_STATIC_FINAL_INT_HIDING_VALUE;
	private static int privateStaticIntField;
	private final int privateFinalIntField = ExtraFieldUtilsTest.PRIVATE_FINAL_INT_HIDING_VALUE;
	private int privateIntField;
	private static final String PRIVATE_STATIC_FINAL_STRING_FIELD = ExtraFieldUtilsTest.PRIVATE_STATIC_FINAL_STRING_HIDING_VALUE;
	private static String privateStaticStringField;
	private final String privateFinalStringField = ExtraFieldUtilsTest.PRIVATE_FINAL_STRING_HIDING_VALUE;
	private String privateStringField;
}
