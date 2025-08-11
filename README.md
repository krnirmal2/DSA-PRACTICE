<!--
Java Data Structure Decision Tree

Use this PlantUML code with any PlantUML viewer or IntelliJ plugin to render the diagram.
-->

```plantuml
@startuml
start

if (Is order important?) then (Yes)
    if (Last In First Out (LIFO)?) then (Yes)
        :Use Stack;
    else (No)
        if (First In First Out (FIFO)?) then (Yes)
            :Use Queue (LinkedList or ArrayDeque);
        else (No)
            if (Need elements sorted by priority?) then (Yes)
                :Use PriorityQueue;
            else (No)
                if (Need to access elements by key?) then (Yes)
                    if (Should elements be sorted by key?) then (Yes)
                        if (Allow duplicate keys?) then (Yes)
                            :Use Multimap (Guava);
                        else (No)
                            :Use TreeMap;
                        endif
                    else (No)
                        if (Maintain insertion order?) then (Yes)
                            :Use LinkedHashMap;
                        else (No)
                            :Use HashMap;
                        endif
                    endif
                else (No)
                    if (Allow duplicates?) then (Yes)
                        if (Maintain insertion order?) then (Yes)
                            :Use LinkedHashSet;
                        else (No)
                            :Use HashSet;
                        endif
                    else (No)
                        if (Should elements be sorted?) then (Yes)
                            :Use TreeSet;
                        else (No)
                            if (Frequent insertion/removal at front or middle?) then (Yes)
                                :Use LinkedList;
                            else (No)
                                if (Random access is important?) then (Yes)
                                    :Use ArrayList;
                                else (No)
                                    if (Need double-ended operations?) then (Yes)
                                        :Use ArrayDeque;
                                    else (No)
                                        :Use ArrayList;
                                    endif
                                endif
                            endif
                        endif
                    endif
                endif
            endif
        endif
    endif
else (No)
    if (Need to access elements by key?) then (Yes)
        if (Should elements be sorted by key?) then (Yes)
            if (Allow duplicate keys?) then (Yes)
                :Use Multimap (Guava);
            else (No)
                :Use TreeMap;
            endif
        else (No)
            if (Maintain insertion order?) then (Yes)
                :Use LinkedHashMap;
            else (No)
                :Use HashMap;
            endif
        endif
    else (No)
        if (Allow duplicates?) then (Yes)
            if (Maintain insertion order?) then (Yes)
                :Use LinkedHashSet;
            else (No)
                :Use HashSet;
            endif
        else (No)
            if (Should elements be sorted?) then (Yes)
                :Use TreeSet;
            else (No)
                if (Frequent insertion/removal at front or middle?) then (Yes)
                    :Use LinkedList;
                else (No)
                    if (Random access is important?) then (Yes)
                        :Use ArrayList;
                    else (No)
                        if (Need double-ended operations?) then (Yes)
                            :Use ArrayDeque;
                        else (No)
                            :Use ArrayList;
                        endif
                    endif
                endif
            endif
        endif
    endif
endif

stop
@enduml
