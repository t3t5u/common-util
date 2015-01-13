package com.github.t3t5u.common.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlushedInputStream extends FilterInputStream {
	public FlushedInputStream(final InputStream in) {
		super(in);
	}

	@Override
	public long skip(final long n) throws IOException {
		long totalBytesSkipped = 0;
		while (totalBytesSkipped < n) {
			final long bytesSkipped = in.skip(n - totalBytesSkipped);
			if ((bytesSkipped < 1) && (read() < 0)) {
				break;
			}
			totalBytesSkipped += bytesSkipped < 1 ? 1 : bytesSkipped;
		}
		return totalBytesSkipped;
	}
}
