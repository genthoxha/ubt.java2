package Mixed.skijatori;

import java.util.Arrays;
import java.util.List;

public enum DisciplinaEnum {


    Slalom("S", "Slalom"),
    GiantSlalom("GS","Giant Slalom"),
    Downhill("D", "Downhill");

    private String code;
    private String name;

    private DisciplinaEnum(String code, String name) {
        this.code = code;
        this.name = name;

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + code + ")" + name;
    }

    public List<DisciplinaEnum> asList() {
        return Arrays.asList(values());
    }

    public DisciplinaEnum getDisciplinaByCode(String code) {
        for (DisciplinaEnum disciplina : values()) {
            if (this.code.equals(code)) {
                return disciplina;
            }
        }
        return null;
    }



}
