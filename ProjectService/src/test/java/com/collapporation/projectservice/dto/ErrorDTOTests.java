package com.collapporation.projectservice.dto;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.models.dto.ErrorDto;
import com.collapporation.projectservice.models.dto.ProjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class ErrorDTOTests
{
    @Test
    public void noArgsContructorTest()
    {
        final ErrorDto errorDto = new ErrorDto();

        assertThat(errorDto).isNotNull();
        assertThat(errorDto.getDescription()).isNull();
        assertThat(errorDto.getSource()).isNull();
    }

    @Test
    public void errorDtoConstructorTest()
    {
        final ErrorDto errorDto = new ErrorDto("Test", "source");

        assertThat(errorDto).isNotNull();
        assertThat(errorDto.getDescription()).isEqualTo("Test");
        assertThat(errorDto.getSource()).isEqualTo("source");
    }

    @Test
    public void emptyEqualTest()
    {
        final ErrorDto errorDtoA = new ErrorDto();
        final ErrorDto errorDtoB = new ErrorDto();
        assertThat(errorDtoA).isNotEqualTo(errorDtoB);
    }

    @Test
    public void notEqualTest() {
        final ErrorDto errorDtoA = new ErrorDto();
        final ErrorDto errorDtoB = new ErrorDto();

        errorDtoA.setDescription("different description than errorb");

        assertThat(errorDtoA).isNotEqualTo(errorDtoB);
    }
}
