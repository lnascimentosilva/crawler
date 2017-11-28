package br.com.hiretest.crawler.feed.model;

public class SingleContentItem extends ContentItem {

	private String content;	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((this.getType() == null) ? 0 : this.getType().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleContentItem other = (SingleContentItem) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (this.getType() == null) {
			if (other.getType() != null)
				return false;
		} else if (!this.getType().equals(other.getType()))
			return false;
		return true;
	}

}
