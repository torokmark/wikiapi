package org.wikiapi.entities;

public class MemberInfo {
    public long pageId;
    public int ns;
    public String title;

    public MemberInfo() {
    }

    public MemberInfo(final long pageId, final int ns, final String title) {
        this.pageId = pageId;
        this.ns = ns;
        this.title = title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ns;
        result = prime * result + (int) (pageId ^ (pageId >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MemberInfo other = (MemberInfo) obj;
        if (ns != other.ns) {
            return false;
        }
        if (pageId != other.pageId) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MemberInfo [pageId=");
        builder.append(pageId);
        builder.append(", ns=");
        builder.append(ns);
        builder.append(", title=");
        builder.append(title);
        builder.append("]");
        return builder.toString();
    }

}
