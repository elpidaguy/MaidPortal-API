package com.app.pojos;

import java.util.List;

public class BaseWrapper {

	private List<?> items;

	public class Meta {
		private int page, pageSize, totalCount, totalPages;

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int i) {
			this.totalCount = i;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}

		@Override
		public String toString() {
			return "Meta [page=" + page + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPages="
					+ totalPages + "]";
		}
		
		

	}

	Meta meta;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "BaseWrapper [items=" + items + ", meta=" + meta + "]";
	}

	
}
