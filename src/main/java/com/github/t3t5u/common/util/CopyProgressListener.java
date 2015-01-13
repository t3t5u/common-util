package com.github.t3t5u.common.util;

import java.io.IOException;

public interface CopyProgressListener {
	boolean onProgress(long totalCopied, boolean finished);

	void onFailure(IOException e);
}
