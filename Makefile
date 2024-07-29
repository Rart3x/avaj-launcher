SRC_DIR := src/avaj
JC := javac

SOURCES := $(wildcard $(SRC_DIR)/*.java)

MAIN_CLASS := Main

GREEN = \033[0;32m
RESET = \033[0m

default: compile

compile:
	@echo "$(GREEN)Compiling dependencies...$(RESET)"
	@$(JC) $(SOURCES)

fclean:
	@echo "$(GREEN)Class obj cleaned.$(RESET)"
	@find $(SRC_DIR) -name "*.class" -type f -exec rm {} \;

.PHONY: default compile fclean