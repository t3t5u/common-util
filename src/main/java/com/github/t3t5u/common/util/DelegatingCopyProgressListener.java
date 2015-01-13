package com.github.t3t5u.common.util;

import java.io.IOException;

public class DelegatingCopyProgressListener implements CopyProgressListener {
	private final CopyProgressListener listener;

	public DelegatingCopyProgressListener(final CopyProgressListener listener) {
		this.listener = listener;
	}

	@Override
	public boolean onProgress(final long totalCopied, final boolean finished) {
		return listener.onProgress(totalCopied, finished);
	}

	@Override
	public void onFailure(final IOException e) {
		listener.onFailure(e);
	}
}
