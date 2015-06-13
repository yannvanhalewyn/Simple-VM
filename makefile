# Compiler
JC = javac

# Directories
SRCDIR = src

# Sources
SOURCES := $(shell find $(SRCDIR) -name '*.java')
OBJECTS := $(SOURCES:$(SRCDIR)/%.java=%.class)

#FLAGS
JFLAGS = -g -deprecation -d ./

$(OBJECTS): $(SOURCES)
	@[ -d $(CLASSDIR) ] || mkdir $(CLASSDIR)
	$(JC) $(JFLAGS) $(SOURCES)

# Helpers
clean:
	rm -f $(OBJECTS)

print_vars:
	@echo SOURCES = $(SOURCES)
	@echo OBJECTS = $(OBJECTS)

run: $(OBJECTS)
	@java vm.Test

PHONY: clean test run teststepped
