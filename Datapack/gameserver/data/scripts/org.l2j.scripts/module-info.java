open module org.l2j.scripts {

    requires java.logging;
    requires org.l2j.gameserver;
    requires org.l2j.commons;
    requires java.sql;
    requires java.desktop;
    requires org.slf4j;
    requires io.github.joealisson.primitive;

    exports handlers;
    exports quests;
    exports events;
    exports instances;
    exports ai;

    uses instances.AbstractInstance;
    uses events.ScriptEvent;
    uses ai.AbstractNpcAI;
    uses org.l2j.gameserver.handler.IActionHandler;
    uses org.l2j.gameserver.handler.IActionShiftHandler;
    uses org.l2j.gameserver.handler.IAdminCommandHandler;
    uses org.l2j.gameserver.handler.IBypassHandler;
    uses org.l2j.gameserver.handler.IChatHandler;
    uses org.l2j.gameserver.handler.IParseBoardHandler;
    uses org.l2j.gameserver.handler.IItemHandler;
    uses org.l2j.gameserver.handler.IPunishmentHandler;
    uses org.l2j.gameserver.handler.IUserCommandHandler;
    uses org.l2j.gameserver.handler.IVoicedCommandHandler;
    uses org.l2j.gameserver.handler.ITargetTypeHandler;
    uses org.l2j.gameserver.handler.IAffectObjectHandler;
    uses org.l2j.gameserver.handler.IAffectScopeHandler;
    uses org.l2j.gameserver.handler.IPlayerActionHandler;
    uses org.l2j.gameserver.model.quest.Quest;

    provides instances.AbstractInstance
        with  instances.MonsterArena.MonsterArena;

    provides events.ScriptEvent
        with events.ChefMonkeyEvent.ChefMonkeyEvent,
            events.EveTheFortuneTeller.EveTheFortuneTeller,
            events.HappyHours.HappyHours,
            events.LetterCollector.LetterCollector,
            events.MerrySquashmas.MerrySquashmas,
            events.SquashEvent.SquashEvent,
            events.ThePowerOfLove.ThePowerOfLove,
            events.TotalRecall.TotalRecall,
            events.WatermelonNinja.WatermelonNinja,

            // custom
            custom.events.Elpies.Elpies,
            custom.events.Rabbits.Rabbits,
            custom.events.Race.Race,
            custom.events.TeamVsTeam.TvT;

    provides ai.AbstractNpcAI
        with  ai.areas.CrumaTower.SummonPc,
            ai.areas.DragonValley.CaveMaiden,
            ai.areas.DungeonOfAbyss.SoulTracker.Ingrit,
            ai.areas.DungeonOfAbyss.SoulTracker.Iris,
            ai.areas.DungeonOfAbyss.SoulTracker.Magrit,
            ai.areas.DungeonOfAbyss.SoulTracker.Rosammy,
            ai.areas.DwarvenVillage.Toma.Toma,
            ai.areas.LairOfAntharas.Pytan,
            ai.areas.TalkingIsland.Roxxy,
            ai.areas.TowerOfInsolence.Ateld.Ateld,

            ai.bosses.Antharas.Antharas,
            ai.bosses.Baium.Baium,
            ai.bosses.Core.Core,
            ai.bosses.Orfen.Orfen,
            ai.bosses.QueenAnt.QueenAnt,
            ai.bosses.Zaken.Zaken,

            ai.others.CastleBlacksmith.CastleBlacksmith,
            ai.others.CastleChamberlain.CastleChamberlain,
            ai.others.CastleDoorManager.CastleDoorManager,
            ai.others.CastleMercenaryManager.CastleMercenaryManager,
            ai.others.CastleSiegeManager.CastleSiegeManager,
            ai.others.CastleTeleporter.CastleTeleporter,
            ai.others.CastleWarehouse.CastleWarehouse,
            ai.others.ClanHallAuctioneer.ClanHallAuctioneer,
            ai.others.ClanHallDoorManager.ClanHallDoorManager,
            ai.others.ClanHallManager.ClanHallManager,
            ai.others.ClassMaster.ClassMaster,
            ai.others.MonumentOfHeroes.MonumentOfHeroes,
            ai.others.NewbieGuide.NewbieGuide,
            ai.others.OlyBuffer.OlyBuffer,
            ai.others.Proclaimer.Proclaimer,
            ai.others.Servitors.SinEater,
            ai.others.Servitors.TreeOfLife,
            ai.others.Spawns.EilhalderVonHellmann,
            ai.others.Spawns.DayNightSpawns,
            ai.others.Spawns.NoRandomActivity,
            ai.others.SymbolMaker.SymbolMaker,
            ai.others.TeleportToRaceTrack.TeleportToRaceTrack,
            ai.others.TeleportWithCharm.TeleportWithCharm,
            ai.others.ToIVortex.ToIVortex,
            ai.others.WyvernManager.WyvernManager,
            ai.others.DivineBeast,
            ai.others.FairyTrees,
            ai.others.FleeMonsters,
            ai.others.Incarnation,
            ai.others.NonLethalableNpcs,
            ai.others.PolymorphingAngel,
            ai.others.PolymorphingOnAttack,
            ai.others.RandomWalkingGuards,
            ai.others.SeeThroughSilentMove,
            ai.others.SiegeGuards,
            ai.others.TimakOrcTroopLeader,

            village.master.Alliance.Alliance,
            village.master.Clan.Clan,
            village.master.DarkElfChange1.DarkElfChange1,
            village.master.OrcChange2.OrcChange2,
            village.master.OrcChange1.OrcChange1,
            village.master.FirstClassTransferTalk.FirstClassTransferTalk,
            village.master.ElfHumanWizardChange2.ElfHumanWizardChange2,
            village.master.ElfHumanWizardChange1.ElfHumanWizardChange1,
            village.master.ElfHumanFighterChange2.ElfHumanFighterChange2,
            village.master.ElfHumanFighterChange1.ElfHumanFighterChange1,
            village.master.ElfHumanClericChange2.ElfHumanClericChange2,
            village.master.DwarfWarehouseChange2.DwarfWarehouseChange2,
            village.master.DwarfWarehouseChange1.DwarfWarehouseChange1,
            village.master.DwarfBlacksmithChange2.DwarfBlacksmithChange2,
            village.master.DwarfBlacksmithChange1.DwarfBlacksmithChange1,
            village.master.DarkElfChange2.DarkElfChange2,

            //  custom
            custom.listeners.ListenerTest,
            custom.NpcLocationInfo.NpcLocationInfo;

    provides org.l2j.gameserver.handler.IActionHandler
        with handlers.actionhandlers.L2ArtefactInstanceAction,
            handlers.actionhandlers.L2DecoyAction,
            handlers.actionhandlers.L2DoorInstanceAction,
            handlers.actionhandlers.L2ItemInstanceAction,
            handlers.actionhandlers.L2NpcAction,
            handlers.actionhandlers.L2PcInstanceAction,
            handlers.actionhandlers.L2PetInstanceAction,
            handlers.actionhandlers.L2StaticObjectInstanceAction,
            handlers.actionhandlers.L2SummonAction,
            handlers.actionhandlers.L2TrapAction;

    provides org.l2j.gameserver.handler.IActionShiftHandler
        with handlers.actionshifthandlers.L2DoorInstanceActionShift,
            handlers.actionshifthandlers.L2ItemInstanceActionShift,
            handlers.actionshifthandlers.L2NpcActionShift,
            handlers.actionshifthandlers.L2PcInstanceActionShift,
            handlers.actionshifthandlers.L2StaticObjectInstanceActionShift,
            handlers.actionshifthandlers.L2SummonActionShift;

    provides org.l2j.gameserver.handler.IAdminCommandHandler
        with handlers.admincommandhandlers.AdminHtml,
            handlers.admincommandhandlers.AdminEditChar,
            handlers.admincommandhandlers.AdminShowQuests,
            handlers.admincommandhandlers.AdminAdmin,
            handlers.admincommandhandlers.AdminEnchant,
            handlers.admincommandhandlers.AdminMenu,
            handlers.admincommandhandlers.AdminPathNode,
            handlers.admincommandhandlers.AdminPunishment,
            handlers.admincommandhandlers.AdminQuest,
            handlers.admincommandhandlers.AdminReload,
            handlers.admincommandhandlers.AdminRepairChar,
            handlers.admincommandhandlers.AdminRes,
            handlers.admincommandhandlers.AdminShop,
            handlers.admincommandhandlers.AdminSkill,
            handlers.admincommandhandlers.AdminSpawn,
            handlers.admincommandhandlers.AdminSuperHaste,
            handlers.admincommandhandlers.AdminTeleport,
            handlers.admincommandhandlers.AdminUnblockIp,
            handlers.admincommandhandlers.AdminAnnouncements,
            handlers.admincommandhandlers.AdminBBS,
            handlers.admincommandhandlers.AdminBuffs,
            handlers.admincommandhandlers.AdminCamera,
            handlers.admincommandhandlers.AdminCastle,
            handlers.admincommandhandlers.AdminChangeAccessLevel,
            handlers.admincommandhandlers.AdminClan,
            handlers.admincommandhandlers.AdminClanHall,
            handlers.admincommandhandlers.AdminCreateItem,
            handlers.admincommandhandlers.AdminCursedWeapons,
            handlers.admincommandhandlers.AdminDelete,
            handlers.admincommandhandlers.AdminDestroyItems,
            handlers.admincommandhandlers.AdminDisconnect,
            handlers.admincommandhandlers.AdminDoorControl,
            handlers.admincommandhandlers.AdminEffects,
            handlers.admincommandhandlers.AdminElement,
            handlers.admincommandhandlers.AdminEventEngine,
            handlers.admincommandhandlers.AdminEvents,
            handlers.admincommandhandlers.AdminExpSp,
            handlers.admincommandhandlers.AdminFence,
            handlers.admincommandhandlers.AdminFightCalculator,
            handlers.admincommandhandlers.AdminFortSiege,
            handlers.admincommandhandlers.AdminGeodata,
            handlers.admincommandhandlers.AdminGm,
            handlers.admincommandhandlers.AdminGmChat,
            handlers.admincommandhandlers.AdminGmSpeed,
            handlers.admincommandhandlers.AdminGraciaSeeds,
            handlers.admincommandhandlers.AdminGrandBoss,
            handlers.admincommandhandlers.AdminHeal,
            handlers.admincommandhandlers.AdminHide,
            handlers.admincommandhandlers.AdminHwid,
            handlers.admincommandhandlers.AdminInstance,
            handlers.admincommandhandlers.AdminInstanceZone,
            handlers.admincommandhandlers.AdminInvul,
            handlers.admincommandhandlers.AdminKick,
            handlers.admincommandhandlers.AdminKill,
            handlers.admincommandhandlers.AdminLevel,
            handlers.admincommandhandlers.AdminLogin,
            handlers.admincommandhandlers.AdminManor,
            handlers.admincommandhandlers.AdminMessages,
            handlers.admincommandhandlers.AdminMissingHtmls,
            handlers.admincommandhandlers.AdminMobGroup,
            handlers.admincommandhandlers.AdminOlympiad,
            handlers.admincommandhandlers.AdminPcCafePoints,
            handlers.admincommandhandlers.AdminPcCondOverride,
            handlers.admincommandhandlers.AdminPetition,
            handlers.admincommandhandlers.AdminPForge,
            handlers.admincommandhandlers.AdminPledge,
            handlers.admincommandhandlers.AdminPremium,
            handlers.admincommandhandlers.AdminPrimePoints,
            handlers.admincommandhandlers.AdminRide,
            handlers.admincommandhandlers.AdminScan,
            handlers.admincommandhandlers.AdminServerInfo,
            handlers.admincommandhandlers.AdminShutdown,
            handlers.admincommandhandlers.AdminSummon,
            handlers.admincommandhandlers.AdminTarget,
            handlers.admincommandhandlers.AdminTargetSay,
            handlers.admincommandhandlers.AdminTest,
            handlers.admincommandhandlers.AdminTransform,
            handlers.admincommandhandlers.AdminVitality,
            handlers.admincommandhandlers.AdminZone,
            handlers.admincommandhandlers.AdminZones;

    provides org.l2j.gameserver.handler.IBypassHandler
        with  handlers.bypasshandlers.NpcViewMod,
            handlers.bypasshandlers.Augment,
            handlers.bypasshandlers.Buy,
            handlers.bypasshandlers.ChatLink,
            handlers.bypasshandlers.ClanWarehouse,
            handlers.bypasshandlers.EnsoulWindow,
            handlers.bypasshandlers.EventEngine,
            handlers.bypasshandlers.FindPvP,
            handlers.bypasshandlers.Freight,
            handlers.bypasshandlers.ItemAuctionLink,
            handlers.bypasshandlers.Link,
            handlers.bypasshandlers.Multisell,
            handlers.bypasshandlers.Observation,
            handlers.bypasshandlers.PlayerHelp,
            handlers.bypasshandlers.PrivateWarehouse,
            handlers.bypasshandlers.QuestLink,
            handlers.bypasshandlers.ReleaseAttribute,
            handlers.bypasshandlers.SkillList,
            handlers.bypasshandlers.SupportBlessing,
            handlers.bypasshandlers.TerritoryStatus,
            handlers.bypasshandlers.SupportMagic,
            handlers.bypasshandlers.TutorialClose,
            handlers.bypasshandlers.VoiceCommand,
            handlers.bypasshandlers.Wear,

            //custom
            custom.SellBuff.SellBuff;

    provides org.l2j.gameserver.handler.IChatHandler
        with handlers.chathandlers.ChatAlliance,
            handlers.chathandlers.ChatClan,
            handlers.chathandlers.ChatGeneral,
            handlers.chathandlers.ChatHeroVoice,
            handlers.chathandlers.ChatParty,
            handlers.chathandlers.ChatPartyMatchRoom,
            handlers.chathandlers.ChatPartyRoomAll,
            handlers.chathandlers.ChatPartyRoomCommander,
            handlers.chathandlers.ChatPetition,
            handlers.chathandlers.ChatShout,
            handlers.chathandlers.ChatTrade,
            handlers.chathandlers.ChatWhisper,
            handlers.chathandlers.ChatWorld;

    provides org.l2j.gameserver.handler.IParseBoardHandler
        with handlers.communityboard.FavoriteBoard,
            handlers.communityboard.DropSearchBoard,
            handlers.communityboard.ClanBoard,
            handlers.communityboard.RegionBoard,
            handlers.communityboard.FriendsBoard,
            handlers.communityboard.HomeBoard,
            handlers.communityboard.HomepageBoard,
            handlers.communityboard.MailBoard,
            handlers.communityboard.MemoBoard;

    provides org.l2j.gameserver.handler.IItemHandler
        with handlers.itemhandlers.ItemSkillsTemplate,
            handlers.itemhandlers.ItemSkills,
            handlers.itemhandlers.BeastSoulShot,
            handlers.itemhandlers.BeastSpiritShot,
            handlers.itemhandlers.BlessedSoulShots,
            handlers.itemhandlers.BlessedSpiritShot,
            handlers.itemhandlers.Book,
            handlers.itemhandlers.Bypass,
            handlers.itemhandlers.Calculator,
            handlers.itemhandlers.ChangeAttributeCrystal,
            handlers.itemhandlers.CharmOfCourage,
            handlers.itemhandlers.Elixir,
            handlers.itemhandlers.EnchantAttribute,
            handlers.itemhandlers.EnchantScrolls,
            handlers.itemhandlers.EventItem,
            handlers.itemhandlers.ExtractableItems,
            handlers.itemhandlers.FatedSupportBox,
            handlers.itemhandlers.FishShots,
            handlers.itemhandlers.Harvester,
            handlers.itemhandlers.Maps,
            handlers.itemhandlers.MercTicket,
            handlers.itemhandlers.NicknameColor,
            handlers.itemhandlers.PetFood,
            handlers.itemhandlers.Recipes,
            handlers.itemhandlers.RollingDice,
            handlers.itemhandlers.Seed,
            handlers.itemhandlers.SoulShots,
            handlers.itemhandlers.SpecialXMas,
            handlers.itemhandlers.SpiritShot,
            handlers.itemhandlers.SummonItems;

    provides org.l2j.gameserver.handler.IPunishmentHandler
        with handlers.punishmenthandlers.BanHandler,
            handlers.punishmenthandlers.ChatBanHandler,
            handlers.punishmenthandlers.JailHandler;

    provides org.l2j.gameserver.handler.IUserCommandHandler
        with handlers.usercommandhandlers.ClanWarsList,
            handlers.usercommandhandlers.ChannelDelete,
            handlers.usercommandhandlers.ChannelInfo,
            handlers.usercommandhandlers.ChannelLeave,
            handlers.usercommandhandlers.ClanPenalty,
            handlers.usercommandhandlers.Dismount,
            handlers.usercommandhandlers.Unstuck,
            handlers.usercommandhandlers.Time,
            handlers.usercommandhandlers.SiegeStatus,
            handlers.usercommandhandlers.PartyInfo,
            handlers.usercommandhandlers.OlympiadStat,
            handlers.usercommandhandlers.MyBirthday,
            handlers.usercommandhandlers.Mount,
            handlers.usercommandhandlers.Loc,
            handlers.usercommandhandlers.InstanceZone;

    provides org.l2j.gameserver.handler.IVoicedCommandHandler
        with handlers.voicedcommandhandlers.ExperienceGain,
            handlers.voicedcommandhandlers.SetVCmd,
            handlers.voicedcommandhandlers.CastleVCmd,
            handlers.voicedcommandhandlers.StatsVCmd,
            handlers.voicedcommandhandlers.Premium,
            handlers.voicedcommandhandlers.Lang,
            handlers.voicedcommandhandlers.ChatAdmin,
            handlers.voicedcommandhandlers.Banking,
            handlers.voicedcommandhandlers.AutoPotion,
            handlers.voicedcommandhandlers.ChangePassword,

            //custom
            custom.SellBuff.SellBuff;


    provides org.l2j.gameserver.handler.ITargetTypeHandler
        with handlers.targethandlers.WyvernTarget,
            handlers.targethandlers.Target,
            handlers.targethandlers.Summon,
            handlers.targethandlers.Self,
            handlers.targethandlers.PcBody,
            handlers.targethandlers.OwnerPet,
            handlers.targethandlers.Others,
            handlers.targethandlers.NpcBody,
            handlers.targethandlers.None,
            handlers.targethandlers.MyParty,
            handlers.targethandlers.MyMentor,
            handlers.targethandlers.Item,
            handlers.targethandlers.HolyThing,
            handlers.targethandlers.Ground,
            handlers.targethandlers.FortressFlagpole,
            handlers.targethandlers.EnemyOnly,
            handlers.targethandlers.EnemyNot,
            handlers.targethandlers.DoorTreasure,
            handlers.targethandlers.AdvanceBase,
            handlers.targethandlers.Artillery;

    provides org.l2j.gameserver.handler.IAffectObjectHandler
        with handlers.targethandlers.affectobject.All,
            handlers.targethandlers.affectobject.WyvernObject,
            handlers.targethandlers.affectobject.UndeadRealEnemy,
            handlers.targethandlers.affectobject.ObjectDeadNpcBody,
            handlers.targethandlers.affectobject.NotFriendPc,
            handlers.targethandlers.affectobject.Invisible,
            handlers.targethandlers.affectobject.HiddenPlace,
            handlers.targethandlers.affectobject.FriendPc,
            handlers.targethandlers.affectobject.Clan;

    provides org.l2j.gameserver.handler.IAffectScopeHandler
        with handlers.targethandlers.affectscope.BalakasScope,
            handlers.targethandlers.affectscope.WyvernScope,
            handlers.targethandlers.affectscope.SummonExceptMaster,
            handlers.targethandlers.affectscope.StaticObjectScope,
            handlers.targethandlers.affectscope.SquarePB,
            handlers.targethandlers.affectscope.Single,
            handlers.targethandlers.affectscope.RingRange,
            handlers.targethandlers.affectscope.RangeSortByHp,
            handlers.targethandlers.affectscope.PointBlank,
            handlers.targethandlers.affectscope.Pledge,
            handlers.targethandlers.affectscope.PartyPledge,
            handlers.targethandlers.affectscope.FanPB,
            handlers.targethandlers.affectscope.DeadUnion,
            handlers.targethandlers.affectscope.DeadPledge,
            handlers.targethandlers.affectscope.DeadPartyPledge;

    provides org.l2j.gameserver.handler.IPlayerActionHandler
        with handlers.playeractions.PrivateStore,
            handlers.playeractions.UnsummonServitor,
            handlers.playeractions.UnsummonPet,
            handlers.playeractions.TeleportBookmark,
            handlers.playeractions.TacticalSignUse,
            handlers.playeractions.TacticalSignTarget,
            handlers.playeractions.SocialAction,
            handlers.playeractions.SitStand,
            handlers.playeractions.ServitorStop,
            handlers.playeractions.ServitorSkillUse,
            handlers.playeractions.ServitorMove,
            handlers.playeractions.ServitorMode,
            handlers.playeractions.ServitorHold,
            handlers.playeractions.ServitorAttack,
            handlers.playeractions.RunWalk,
            handlers.playeractions.Ride,
            handlers.playeractions.PetStop,
            handlers.playeractions.PetSkillUse,
            handlers.playeractions.PetMove,
            handlers.playeractions.PetHold,
            handlers.playeractions.PetAttack,
            handlers.playeractions.InstanceZoneInfo,
            handlers.playeractions.BotReport,
            handlers.playeractions.AirshipAction;

    provides org.l2j.gameserver.model.quest.Quest
        with  quests.Q00070_SagaOfThePhoenixKnight.Q00070_SagaOfThePhoenixKnight,
             quests.Q00071_SagaOfEvasTemplar.Q00071_SagaOfEvasTemplar,
             quests.Q00072_SagaOfTheSwordMuse.Q00072_SagaOfTheSwordMuse,
             quests.Q00073_SagaOfTheDuelist.Q00073_SagaOfTheDuelist,
             quests.Q00074_SagaOfTheDreadnought.Q00074_SagaOfTheDreadnought,
             quests.Q00075_SagaOfTheTitan.Q00075_SagaOfTheTitan,
             quests.Q00076_SagaOfTheGrandKhavatari.Q00076_SagaOfTheGrandKhavatari,
             quests.Q00077_SagaOfTheDominator.Q00077_SagaOfTheDominator,
             quests.Q00078_SagaOfTheDoomcryer.Q00078_SagaOfTheDoomcryer,
             quests.Q00079_SagaOfTheAdventurer.Q00079_SagaOfTheAdventurer,
             quests.Q00080_SagaOfTheWindRider.Q00080_SagaOfTheWindRider,
             quests.Q00081_SagaOfTheGhostHunter.Q00081_SagaOfTheGhostHunter,
             quests.Q00082_SagaOfTheSagittarius.Q00082_SagaOfTheSagittarius,
             quests.Q00083_SagaOfTheMoonlightSentinel.Q00083_SagaOfTheMoonlightSentinel,
             quests.Q00084_SagaOfTheGhostSentinel.Q00084_SagaOfTheGhostSentinel,
             quests.Q00085_SagaOfTheCardinal.Q00085_SagaOfTheCardinal,
             quests.Q00086_SagaOfTheHierophant.Q00086_SagaOfTheHierophant,
             quests.Q00087_SagaOfEvasSaint.Q00087_SagaOfEvasSaint,
             quests.Q00088_SagaOfTheArchmage.Q00088_SagaOfTheArchmage,
             quests.Q00089_SagaOfTheMysticMuse.Q00089_SagaOfTheMysticMuse,
             quests.Q00090_SagaOfTheStormScreamer.Q00090_SagaOfTheStormScreamer,
             quests.Q00091_SagaOfTheArcanaLord.Q00091_SagaOfTheArcanaLord,
             quests.Q00092_SagaOfTheElementalMaster.Q00092_SagaOfTheElementalMaster,
             quests.Q00093_SagaOfTheSpectralMaster.Q00093_SagaOfTheSpectralMaster,
             quests.Q00094_SagaOfTheSoultaker.Q00094_SagaOfTheSoultaker,
             quests.Q00095_SagaOfTheHellKnight.Q00095_SagaOfTheHellKnight,
             quests.Q00096_SagaOfTheSpectralDancer.Q00096_SagaOfTheSpectralDancer,
             quests.Q00097_SagaOfTheShillienTemplar.Q00097_SagaOfTheShillienTemplar,
             quests.Q00098_SagaOfTheShillienSaint.Q00098_SagaOfTheShillienSaint,
             quests.Q00099_SagaOfTheFortuneSeeker.Q00099_SagaOfTheFortuneSeeker,
             quests.Q00100_SagaOfTheMaestro.Q00100_SagaOfTheMaestro,
             quests.Q00127_FishingSpecialistsRequest.Q00127_FishingSpecialistsRequest,
             quests.Q00211_TrialOfTheChallenger.Q00211_TrialOfTheChallenger,
             quests.Q00212_TrialOfDuty.Q00212_TrialOfDuty,
             quests.Q00213_TrialOfTheSeeker.Q00213_TrialOfTheSeeker,
             quests.Q00214_TrialOfTheScholar.Q00214_TrialOfTheScholar,
             quests.Q00215_TrialOfThePilgrim.Q00215_TrialOfThePilgrim,
             quests.Q00216_TrialOfTheGuildsman.Q00216_TrialOfTheGuildsman,
             quests.Q00217_TestimonyOfTrust.Q00217_TestimonyOfTrust,
             quests.Q00218_TestimonyOfLife.Q00218_TestimonyOfLife,
             quests.Q00219_TestimonyOfFate.Q00219_TestimonyOfFate,
             quests.Q00220_TestimonyOfGlory.Q00220_TestimonyOfGlory,
             quests.Q00221_TestimonyOfProsperity.Q00221_TestimonyOfProsperity,
             quests.Q00222_TestOfTheDuelist.Q00222_TestOfTheDuelist,
             quests.Q00223_TestOfTheChampion.Q00223_TestOfTheChampion,
             quests.Q00224_TestOfSagittarius.Q00224_TestOfSagittarius,
             quests.Q00225_TestOfTheSearcher.Q00225_TestOfTheSearcher,
             quests.Q00226_TestOfTheHealer.Q00226_TestOfTheHealer,
             quests.Q00227_TestOfTheReformer.Q00227_TestOfTheReformer,
             quests.Q00228_TestOfMagus.Q00228_TestOfMagus,
             quests.Q00229_TestOfWitchcraft.Q00229_TestOfWitchcraft,
             quests.Q00230_TestOfTheSummoner.Q00230_TestOfTheSummoner,
             quests.Q00231_TestOfTheMaestro.Q00231_TestOfTheMaestro,
             quests.Q00232_TestOfTheLord.Q00232_TestOfTheLord,
             quests.Q00233_TestOfTheWarSpirit.Q00233_TestOfTheWarSpirit,
             quests.Q00255_Tutorial.Q00255_Tutorial,
             quests.Q00257_TheGuardIsBusy.Q00257_TheGuardIsBusy,
             quests.Q00258_BringWolfPelts.Q00258_BringWolfPelts,
             quests.Q00259_RequestFromTheFarmOwner.Q00259_RequestFromTheFarmOwner,
             quests.Q00260_OrcHunting.Q00260_OrcHunting,
             quests.Q00261_CollectorsDream.Q00261_CollectorsDream,
             quests.Q00262_TradeWithTheIvoryTower.Q00262_TradeWithTheIvoryTower,
             quests.Q00263_OrcSubjugation.Q00263_OrcSubjugation,
             quests.Q00264_KeenClaws.Q00264_KeenClaws,
             quests.Q00265_BondsOfSlavery.Q00265_BondsOfSlavery,
             quests.Q00266_PleasOfPixies.Q00266_PleasOfPixies,
             quests.Q00267_WrathOfVerdure.Q00267_WrathOfVerdure,
             quests.Q00271_ProofOfValor.Q00271_ProofOfValor,
             quests.Q00272_WrathOfAncestors.Q00272_WrathOfAncestors,
             quests.Q00273_InvadersOfTheHolyLand.Q00273_InvadersOfTheHolyLand,
             quests.Q00274_SkirmishWithTheWerewolves.Q00274_SkirmishWithTheWerewolves,
             quests.Q00275_DarkWingedSpies.Q00275_DarkWingedSpies,
             quests.Q00276_TotemOfTheHestui.Q00276_TotemOfTheHestui,
             quests.Q00277_GatekeepersOffering.Q00277_GatekeepersOffering,
             quests.Q00292_BrigandsSweep.Q00292_BrigandsSweep,
             quests.Q00293_TheHiddenVeins.Q00293_TheHiddenVeins,
             quests.Q00294_CovertBusiness.Q00294_CovertBusiness,
             quests.Q00295_DreamingOfTheSkies.Q00295_DreamingOfTheSkies,
             quests.Q00296_TarantulasSpiderSilk.Q00296_TarantulasSpiderSilk,
             quests.Q00297_GatekeepersFavor.Q00297_GatekeepersFavor,
             quests.Q00300_HuntingLetoLizardman.Q00300_HuntingLetoLizardman,
             quests.Q00303_CollectArrowheads.Q00303_CollectArrowheads,
             quests.Q00306_CrystalOfFireAndIce.Q00306_CrystalOfFireAndIce,
             quests.Q00313_CollectSpores.Q00313_CollectSpores,
             quests.Q00316_DestroyPlagueCarriers.Q00316_DestroyPlagueCarriers,
             quests.Q00317_CatchTheWind.Q00317_CatchTheWind,
             quests.Q00319_ScentOfDeath.Q00319_ScentOfDeath,
             quests.Q00320_BonesTellTheFuture.Q00320_BonesTellTheFuture,
             quests.Q00324_SweetestVenom.Q00324_SweetestVenom,
             quests.Q00325_GrimCollector.Q00325_GrimCollector,
             quests.Q00326_VanquishRemnants.Q00326_VanquishRemnants,
             quests.Q00327_RecoverTheFarmland.Q00327_RecoverTheFarmland,
             quests.Q00328_SenseForBusiness.Q00328_SenseForBusiness,
             quests.Q00329_CuriosityOfADwarf.Q00329_CuriosityOfADwarf,
             quests.Q00331_ArrowOfVengeance.Q00331_ArrowOfVengeance,
             quests.Q00333_HuntOfTheBlackLion.Q00333_HuntOfTheBlackLion,
             quests.Q00344_1000YearsTheEndOfLamentation.Q00344_1000YearsTheEndOfLamentation,
             quests.Q00348_AnArrogantSearch.Q00348_AnArrogantSearch,
             quests.Q00354_ConquestOfAlligatorIsland.Q00354_ConquestOfAlligatorIsland,
             quests.Q00355_FamilyHonor.Q00355_FamilyHonor,
             quests.Q00356_DigUpTheSeaOfSpores.Q00356_DigUpTheSeaOfSpores,
             quests.Q00358_IllegitimateChildOfTheGoddess.Q00358_IllegitimateChildOfTheGoddess,
             quests.Q00360_PlunderTheirSupplies.Q00360_PlunderTheirSupplies,
             quests.Q00369_CollectorOfJewels.Q00369_CollectorOfJewels,
             quests.Q00370_AnElderSowsSeeds.Q00370_AnElderSowsSeeds,
             quests.Q00374_WhisperOfDreamsPart1.Q00374_WhisperOfDreamsPart1,
             quests.Q00375_WhisperOfDreamsPart2.Q00375_WhisperOfDreamsPart2,
             quests.Q00401_PathOfTheWarrior.Q00401_PathOfTheWarrior,
             quests.Q00402_PathOfTheHumanKnight.Q00402_PathOfTheHumanKnight,
             quests.Q00403_PathOfTheRogue.Q00403_PathOfTheRogue,
             quests.Q00404_PathOfTheHumanWizard.Q00404_PathOfTheHumanWizard,
             quests.Q00405_PathOfTheCleric.Q00405_PathOfTheCleric,
             quests.Q00406_PathOfTheElvenKnight.Q00406_PathOfTheElvenKnight,
             quests.Q00407_PathOfTheElvenScout.Q00407_PathOfTheElvenScout,
             quests.Q00408_PathOfTheElvenWizard.Q00408_PathOfTheElvenWizard,
             quests.Q00409_PathOfTheElvenOracle.Q00409_PathOfTheElvenOracle,
             quests.Q00410_PathOfThePalusKnight.Q00410_PathOfThePalusKnight,
             quests.Q00411_PathOfTheAssassin.Q00411_PathOfTheAssassin,
             quests.Q00412_PathOfTheDarkWizard.Q00412_PathOfTheDarkWizard,
             quests.Q00413_PathOfTheShillienOracle.Q00413_PathOfTheShillienOracle,
             quests.Q00414_PathOfTheOrcRaider.Q00414_PathOfTheOrcRaider,
             quests.Q00415_PathOfTheOrcMonk.Q00415_PathOfTheOrcMonk,
             quests.Q00416_PathOfTheOrcShaman.Q00416_PathOfTheOrcShaman,
             quests.Q00417_PathOfTheScavenger.Q00417_PathOfTheScavenger,
             quests.Q00418_PathOfTheArtisan.Q00418_PathOfTheArtisan,
             quests.Q00500_BrothersBoundInChains.Q00500_BrothersBoundInChains,
             quests.Q00662_AGameOfCards.Q00662_AGameOfCards,
             quests.Q00933_ExploringTheWestWingOfTheDungeonOfAbyss.Q00933_ExploringTheWestWingOfTheDungeonOfAbyss,
             quests.Q00935_ExploringTheEastWingOfTheDungeonOfAbyss.Q00935_ExploringTheEastWingOfTheDungeonOfAbyss,
             quests.Q10866_PunitiveOperationOnTheDevilIsle.Q10866_PunitiveOperationOnTheDevilIsle,
             quests.Q10993_FutureDwarves.Q10993_FutureDwarves,
             quests.Q10994_FutureOrcs.Q10994_FutureOrcs,
             quests.Q10995_MutualBenefit.Q10995_MutualBenefit,
             quests.Q10996_TemplesDecorations.Q10996_TemplesDecorations,
             quests.Q10997_LoserPriest1.Q10997_LoserPriest1,
             quests.Q10998_LoserPriest2.Q10998_LoserPriest2,
             quests.Q10999_LoserPriest3.Q10999_LoserPriest3,
             quests.Q11000_MoonKnight.Q11000_MoonKnight,
             quests.Q11001_TombsOfAncestors.Q11001_TombsOfAncestors,
             quests.Q11002_HelpWithTempleRestoration.Q11002_HelpWithTempleRestoration,
             quests.Q11003_PerfectLeatherArmor1.Q11003_PerfectLeatherArmor1,
             quests.Q11004_PerfectLeatherArmor2.Q11004_PerfectLeatherArmor2,
             quests.Q11005_PerfectLeatherArmor3.Q11005_PerfectLeatherArmor3,
             quests.Q11006_FuturePeople.Q11006_FuturePeople,
             quests.Q11007_NoiseInWoods.Q11007_NoiseInWoods,
             quests.Q11008_PreparationForDungeon.Q11008_PreparationForDungeon,
             quests.Q11009_NewPotionDevelopment1.Q11009_NewPotionDevelopment1,
             quests.Q11010_NewPotionDevelopment2.Q11010_NewPotionDevelopment2,
             quests.Q11011_NewPotionDevelopment3.Q11011_NewPotionDevelopment3,
             quests.Q11012_FutureElves.Q11012_FutureElves,
             quests.Q11013_ShilensHunt.Q11013_ShilensHunt,
             quests.Q11014_SurpriseGift.Q11014_SurpriseGift,
             quests.Q11015_PrepareForTrade1.Q11015_PrepareForTrade1,
             quests.Q11016_PrepareForTrade2.Q11016_PrepareForTrade2,
             quests.Q11017_PrepareForTrade3.Q11017_PrepareForTrade3,
             quests.Q11018_FutureDarkElves.Q11018_FutureDarkElves,
             quests.Q11019_TribalBenefit.Q11019_TribalBenefit,
             quests.Q11020_BlacksmithsRequest.Q11020_BlacksmithsRequest,
             quests.Q11021_RedGemNecklace1.Q11021_RedGemNecklace1,
             quests.Q11022_RedGemNecklace2.Q11022_RedGemNecklace2,
             quests.Q11023_RedGemNecklace3.Q11023_RedGemNecklace3;
}