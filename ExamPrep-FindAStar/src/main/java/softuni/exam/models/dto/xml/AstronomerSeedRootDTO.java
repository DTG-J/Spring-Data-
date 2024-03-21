package softuni.exam.models.dto.xml;

import softuni.exam.models.dto.xml.AstronomerSeedDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerSeedRootDTO {
    @XmlElement(name = "astronomer")
    private List<AstronomerSeedDTO>astronomerSeedDto;

    public List<AstronomerSeedDTO> getAstronomerSeedDto() {
        return astronomerSeedDto;
    }

    public void setAstronomerSeedDto(List<AstronomerSeedDTO> astronomerSeedDto) {
        this.astronomerSeedDto = astronomerSeedDto;
    }
}
