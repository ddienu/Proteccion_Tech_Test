package com.diegonunez.TechTestProteccion.service.Impl;

import com.diegonunez.TechTestProteccion.dto.request.FibonacciRequestDTO;
import com.diegonunez.TechTestProteccion.dto.response.FibonacciResponseDTO;
import com.diegonunez.TechTestProteccion.exception.custom.FibonacciZeroBeansException;
import com.diegonunez.TechTestProteccion.exception.custom.NoSeriesFoundException;
import com.diegonunez.TechTestProteccion.exception.custom.SeriesLengthException;
import com.diegonunez.TechTestProteccion.model.entity.Fibonacci;
import com.diegonunez.TechTestProteccion.repository.IFibonacciRepository;
import com.diegonunez.TechTestProteccion.service.IFibonacciService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FibonacciServiceImpl implements IFibonacciService {

    private final IFibonacciRepository fibonacciRepository;

    public FibonacciServiceImpl(IFibonacciRepository fibonacciRepository){
        this.fibonacciRepository = fibonacciRepository;
    }
    @Override
    public List<Long> getFibonacciSeries(FibonacciRequestDTO time) {

        int minutes = time.getTime().getMinute();
        int seconds = time.getTime().getSecond();

        Long[] minutesSeparated = getMinutesSeparated((long) minutes);

        List<Long> result = createFibonacciSeries(minutesSeparated[0], minutesSeparated[1], seconds+2)
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        Fibonacci fibonacciCreated = new Fibonacci();

        fibonacciCreated.setBeans(String.valueOf(minutes));
        fibonacciCreated.setDate(time.getTime());
        fibonacciCreated.setLength(seconds);
        fibonacciCreated.setFibonacciCreated(result.toString());


        fibonacciRepository.save(fibonacciCreated);

        return result;

    }

    @Override
    public List<FibonacciResponseDTO> getAllFibonacciSeries() {
        List<FibonacciResponseDTO> result = fibonacciRepository.findAll().stream()
                .map(
                        response -> new FibonacciResponseDTO(
                                response.getFibonacciId(),
                                response.getDate(),
                                response.getBeans(),
                                response.getLength(),
                                response.getFibonacciCreated()
                        )
                ).toList();

        if( result.isEmpty()){
            throw new NoSeriesFoundException("No fibonacci series save in database");
        }

        return result;
    }

    private Long[] getMinutesSeparated(Long minutes){
        Long[] digits = new Long[2];
        digits[0] = minutes / 10;
        digits[1] = minutes % 10;
        Arrays.sort(digits);
        return digits;
    }

    private List<Long> createFibonacciSeries(Long start1, Long start2, int length){
        if (length <= 2 ){
            throw new SeriesLengthException("The series length is 0");
        }

        if(start1 == 0 && start2 == 0){
            throw new FibonacciZeroBeansException("Impossible to run the fibonacci because there are no numbers to sum");
        }

        List<Long> series = new ArrayList<>();
        series.add(start1);
        series.add(start2);

        for(int i = 2; i < length; i++){
            series.add(series.get(i - 1) + series.get(i - 2));
        }

        return series;
    }
}
