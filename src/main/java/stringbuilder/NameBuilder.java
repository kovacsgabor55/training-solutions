package stringbuilder;

public class NameBuilder {

    public boolean isEmpty(String s) {
        return s == null || s.trim().equals("");
    }

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        StringBuilder sb = new StringBuilder("");

        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        if (title == null && isEmpty(middleName)) {
            sb.append(givenName).append(" ").append(familyName);
        } else if (title == null && !isEmpty(middleName)) {
            sb.append(givenName).append(" ").append(middleName).append(" ").append(familyName);
        } else if (title != null && isEmpty(middleName)) {
            sb.append(title.getTitleString()).append(" ").append(givenName).append(" ").append(familyName);
        } else {
            sb.append(title.getTitleString()).append(" ").append(givenName).append(" ").append(middleName).append(" ").append(familyName);
        }
        return sb.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        StringBuilder sb = new StringBuilder("");

        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        if (title == null && isEmpty(middleName)) {
            sb.append(familyName).append(" ").append(givenName);
        } else if (title == null && !isEmpty(middleName)) {
            sb.append(familyName).append(" ").append(middleName).append(" ").append(givenName);
        } else if (title != null && isEmpty(middleName)) {
            sb.append(title.getTitleString()).append(" ").append(familyName).append(" ").append(givenName);
        } else {
            sb.append(title.getTitleString()).append(" ").append(familyName).append(" ").append(middleName).append(" ").append(givenName);
        }
        return sb.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder sb = new StringBuilder(name);
        int hova = sb.indexOf(where);
        sb.insert(hova, title.getTitleString());
        sb.insert(hova, " ");
        return sb.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder sb = new StringBuilder(name);
        int del = sb.indexOf(delete);
        sb.delete(del, del + delete.length());
        return sb.toString();
    }
}
