package com.whitbread.premierinn;

import org.apache.commons.lang3.StringUtils;
import com.day.cq.dam.api.Asset;

/**
 * Image Asset class used in image group
 */
public class ImageAsset {

	private final Asset asset;
	private final String path;
	private boolean validImage = true;

	public static class Builder {

		private final Asset asset;
		private String assetPath;
		private boolean validImage = true;

		public Builder(final Asset asset) {
			this.asset = asset;
		}

		public ImageAsset build() {
			return new ImageAsset(asset, assetPath, validImage);
		}

		public Builder path(final String assetPath) {
			this.assetPath = StringUtils.defaultString(assetPath);
			return this;
		}

		public Builder error() {
			validImage = false;
			return this;
		}
	}

	private ImageAsset(final Asset asset, final String path, final boolean validImage) {
		this.asset = asset;
		this.path = path;
		this.validImage = validImage;
	}

	public String getPath() {
		return path;
	}

	public boolean isValidImage() {
		return validImage;
	}
}
