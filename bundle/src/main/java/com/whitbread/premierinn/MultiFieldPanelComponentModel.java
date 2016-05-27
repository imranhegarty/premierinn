package com.whitbread.premierinn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class MultiFieldPanelComponentModel extends AbstractValidatableModel {

	public static final int MAX_NO_OF_IMAGES = 12;
	private String[] imagePaths;

	private List<ImageAsset> imageAssets;

	public List<String> getImagePaths() {
		if (imagePaths == null) {
			return Collections.emptyList();
		} else {
			return Collections.unmodifiableList(Arrays.asList(imagePaths));
		}
	}

	public void setImagePaths(String[] imagePaths) {
		if (null != imagePaths) {
			this.imagePaths = Arrays.copyOf(imagePaths, imagePaths.length);
		}
	}

	public List<ImageAsset> getImageAssets() {
		return imageAssets;
	}

	public void setImageAssets(List<ImageAsset> imageAssets) {
		this.imageAssets = imageAssets;
	}

	@Override
	public void validate() {
		if (CollectionUtils.isEmpty(imageAssets)) {
			addError("Image list cannot be empty.");
		} else {
			if (imageAssets.size() > MAX_NO_OF_IMAGES) {
				addError("Image list can not have more than 12 images");
			}
			for (ImageAsset imageAsset : imageAssets) {
				if (!imageAsset.isValidImage()) {
					addError("Path does not point to an image: " + imageAsset.getPath());
				}
			}
		}
	}

}
